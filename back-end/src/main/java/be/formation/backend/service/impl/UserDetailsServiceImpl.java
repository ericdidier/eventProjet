package be.formation.backend.service.impl;

import be.formation.backend.model.entity.User;
import be.formation.backend.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * C'est une classe qui permet de se connecter à la bd pour charge l'utilisateur.
 * On rédefini une methode loadUserByUsername
 * qui reçoit un username et returnUserDetails
 *
 */
@Primary
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User found = userRepository.findByUsername(username);

        if (found == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return found;
    }
}
