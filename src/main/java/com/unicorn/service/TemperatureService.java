package com.unicorn.service;

import com.unicorn.dao.TemperatureDAO;
import com.unicorn.model.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TemperatureService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private TemperatureDAO temperatureDAO;

}
