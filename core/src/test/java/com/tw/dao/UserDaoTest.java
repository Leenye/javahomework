package com.tw.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})

public class UserDaoTest {

    @BeforeClass
    public static void setProperty(){
        System.setProperty("jdbc.active.database","test");
    }

    @Test
    public void testGet_users() throws Exception {

    }

    @Test
    public void testInsert_user() throws Exception {

    }

    @Test
    public void testDelete_user() throws Exception {

    }

    @Test
    public void testGet_element_by_id() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testLogin_judgement() throws Exception {

    }
}