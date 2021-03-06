package be.formation.backend.service.impl;

import be.formation.backend.enums.RoleEnum;
import be.formation.backend.model.entity.Authority;
import be.formation.backend.model.entity.User;
import be.formation.backend.repository.AuthorityRepository;
import be.formation.backend.repository.UserRepository;
import be.formation.backend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, RoleEnum whoAmI) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        // ajouté de(s) role(e)s à un utilisateur.
        switch (whoAmI.getValue()) {
            case "ROLE_USER":
                user.setAuthorities(new ArrayList<>(Collections.singletonList(createOrGetAuthority(RoleEnum.USER.getValue()))));
                break;
            case "ROLE_ADMIN":
                user.setAuthorities(new ArrayList<>());
                user.getAuthorities().add(createOrGetAuthority(RoleEnum.ADMIN.getValue()));
                break;
            case "ROLE_WORKER":
                user.setAuthorities(new ArrayList<>());
                user.getAuthorities().add(createOrGetAuthority(RoleEnum.WORKER.getValue()));
                break;
        }


        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    public Authority createOrGetAuthority(String authority) {

        Authority found = authorityRepository.findByAuthority(authority);

        if (found == null) {
            found = new Authority(authority);
            authorityRepository.save(found);
        }

        return found;
    }
}
