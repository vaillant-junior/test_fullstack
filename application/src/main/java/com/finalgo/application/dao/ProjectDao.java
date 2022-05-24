package com.finalgo.application.dao;

import com.finalgo.application.entity.Project;
import com.finalgo.application.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDao extends AbstractGenericDao<Project> {

    public ProjectDao() {
        super(Project.class);
    }

    public List<Project> findUserOwnerName(String username) {
        String query = "from User u WHERE u.username = '" +username +"'";
        return createSelectQuery(query);
    }
}
