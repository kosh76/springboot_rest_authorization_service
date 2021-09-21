package ru.koshelev.springboot.rest_authorization_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.koshelev.springboot.rest_authorization_service.DAO.UserRepository;
import ru.koshelev.springboot.rest_authorization_service.entity.Authorities;
import ru.koshelev.springboot.rest_authorization_service.exception.InvalidCredentials;
import ru.koshelev.springboot.rest_authorization_service.exception.UnauthorizedUser;

import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getAuthorities(user, password);

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);

        }
        return userAuthorities;

    }


    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
