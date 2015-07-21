package com.tw.service;

import com.tw.dao.UsrDao;
import com.tw.entity.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsrDao usrDao;

    public List<Usr> get_users() {
        return usrDao.get_usrs();
    }

    public void insert_users(Usr usr) {
        usrDao.insert_usr(usr);
    }

    public void delete_user(int id) {
        usrDao.delete_usr(id);
    }

    public Usr get_element_by_id(int id) {
        return usrDao.get_element_by_id(id);
    }

    public void update_user(Usr usr){
        usrDao.update(usr);
    }

    public boolean login_judgement(String name, String password) {
        return usrDao.login_judgement(name, password);
    }



}