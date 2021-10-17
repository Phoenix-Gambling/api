package phoenix.api.service;

import phoenix.api.model.User;

import java.security.Principal;

public interface AuthService {

    User user();

    User user(String name);

    User findById(String id);

    boolean isGuest();

    boolean hasAuthority(String role);

    boolean hasAuthority(Principal principal, String role);

    boolean hasAuthority(User user, String role);

}
