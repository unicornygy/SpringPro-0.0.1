package com.unicorn.service;

import com.unicorn.dao.TemperatureDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class TemperatureService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private TemperatureDAO temperatureDAO;

}
