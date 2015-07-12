package com.tw.core;

import com.tw.dao.UsrDao;
import com.tw.entity.Usr;

import java.util.List;

public class Service {

    public String service() {
        UsrDao usrDao = new UsrDao();
        List<Usr> usrList = usrDao.get_usrs();
        System.out.println(usrList+"==============");
        return "Hello World";
    }
}