package ru.koshelev.springboot.rest_authorization_service.DAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.koshelev.springboot.rest_authorization_service.entity.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Value("#{${users}}")
    private Map<String, String> users;
    private List<Authorities> authoritiesList = new ArrayList<>();

    public UserRepository() {
        authoritiesList.add(Authorities.READ);
        authoritiesList.add(Authorities.WRITE);
        authoritiesList.add(Authorities.DELETE);
    }


    public List<Authorities> getAuthorities(String user, String password) {
        if (users.containsKey(user)) {
            if (users.get(user).equals(password)) {
                return authoritiesList;
            }
        }
        return null;
    }


}



