package com.finalgo.application;

import com.finalgo.application.api.ApplicationRouting;
import com.finalgo.application.bean.ProjectBean;
import com.finalgo.application.bean.RegisterBean;
import com.finalgo.application.dao.ProjectDao;
import com.finalgo.application.dao.UserDao;
import com.finalgo.application.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ApplicationRouting applicationRouting ;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
    }





    // TODO 1. Mettre en place un test pour vérifier le fonctionnement de l'API `register`
    // TODO 2. Mettre en place un test pour vérifier le fonctionnement de l'API `saveProject`
    @Test
    void should_register_send_conflict(){
        //given
        RegisterBean registerBean = new RegisterBean();
        registerBean.setEmail("test@test.fr");
        registerBean.setPassword("test");
        registerBean.setUsername("test");

        User user = new User();
        user.setEmail("test@test.fr");
        user.setPassword("test");
        user.setUsername("test");

        userDao.create(user);

        //when
        var getR = applicationRouting.register(registerBean);

        //then
        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.CONFLICT);

        Assertions.assertEquals(expected,getR);
    }

    @Disabled
    void should_register_send_ok(){
        //given
        RegisterBean registerBean = new RegisterBean();
        registerBean.setEmail("test@test.fr");
        registerBean.setPassword("test");
        registerBean.setUsername("test");

        User user = new User();
        user.setEmail("test2@test.fr");
        user.setPassword("test");
        user.setUsername("test2");
        var userT = userDao.create(user);


        //when
        var getR = applicationRouting.register(registerBean);
        userDao.delete(userT);

        //then
        ResponseEntity<Object> expected = new ResponseEntity<>(HttpStatus.OK);

        Assertions.assertEquals(expected,getR);
    }
    @Test
    void shouldSaveProject(){
        //given
        ProjectBean projectBean = new ProjectBean();
        projectBean.setAmount(10);
        projectBean.setDescription("test 1");
        projectBean.setName("projet 1");
        projectBean.setOwnerUsername("test");
        var countN= projectDao.findAll().stream().count();
        applicationRouting.saveProject(projectBean);
        var project = projectDao.findAll();
        Assertions.assertTrue(project.stream().count()>countN);
    }
}
