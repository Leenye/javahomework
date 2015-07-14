//package com.tw.util;
//
//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
//import org.hibernate.Session;
//
///**
// * Created by twer on 7/13/15.
// */
//public class LoginSession <S extends Session> {
//    private SessionRepository<S> repository;
//
//    public void demo() {
//        S toSave = repository.createSession();
//
//
//        BIConversion.User rwinch = new BIConversion.User("rwinch");
//        toSave.setAttribute(ATTR_USER, rwinch);
//
//        repository.save(toSave);
//
//        S session = repository.getSession(toSave.getId());
//
//
//        BIConversion.User user = session.getAttribute(ATTR_USER);
//        assertThat(user).isEqualTo(rwinch);
//    }
//}
