package com.tw.service;

import com.tw.dao.TimeDao;
import com.tw.entity.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by twer on 7/18/15.
 */
@Service
public class TimeService {

    @Autowired
    TimeDao timeDao;

    public List<Time> get_time() {return timeDao.get_time();}

    public void insert_time(Time time) {
        timeDao.insert_time(time);
    }

    public void delete_time(int time_id) {
        timeDao.delete_time(time_id);
    }

}
