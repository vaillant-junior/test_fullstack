package com.finalgo.application.dao;

import com.finalgo.application.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserDao extends AbstractGenericDao<User> {

    public UserDao() {
        super(User.class);
    }

    /**
     * Récupèrer l'utilisateur correspondant aux paramètres suivant:
     * @param username
     * @param password
     * @return User
     *
     * TODO Implémenter la requête Hibernate/SQL
     */
    public User findWithCredentials(String username, String password) {
        String query = "from User U WHERE U.username = '"+username+"' and U.password='"+password+"'";

        return createOneItemSelectQuery(query);
    }
    public User deleteAll() {
        String query = "delete from User";

        return createOneItemSelectQuery(query);
    }
}
