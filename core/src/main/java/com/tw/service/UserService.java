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

//    public String service() {
//        UsrDao usrDao = new UsrDao();
//        List<Usr> usrList = usrDao.get_usrs();
//        return "Hello World";
//    }


}