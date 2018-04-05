package be.formation.backend.config;

import be.formation.backend.service.UserService;
import be.formation.backend.service.VenueService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements InitializingBean {

    private final UserService userService;
    private final VenueService venueService;
    public DbInit(UserService userService, VenueService venueService) {
        this.userService = userService;
        this.venueService = venueService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

//        userService.register("user", "user", RoleEnum.USER);
//        userService.register("toto", "toto", RoleEnum.USER);
//        userService.register("admin", "admin", RoleEnum.ADMIN);

    }
}
