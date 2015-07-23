package com.tw.service;

import com.tw.dao.CoachDao;
import com.tw.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by twer on 7/22/15.
 */
@Service
public class CoachService {

    @Autowired
    CoachDao coachDao;
    public List<Coach> get_coaches() {
        return coachDao.get_coaches();
    }

}
