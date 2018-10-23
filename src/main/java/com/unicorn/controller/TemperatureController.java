package com.unicorn.controller;

import com.unicorn.dao.TemperatureDAO;
import com.unicorn.model.Temperature;
import com.unicorn.util.ProUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class TemperatureController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private TemperatureDAO temperatureDAO;

    @RequestMapping(path = {"/uploadtem/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String uploadTem(@RequestParam("from") String form,
                            @RequestParam("val") int val) {
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//            Date date = sdf.parse(new Date());
            Date date = new Date();
            Temperature temperature = new Temperature(form,val,date);
            temperatureDAO.addTemperature(temperature);
            logger.info("上传成功");
            return ProUtil.getJSONString(0,"上传温度成功");
        } catch (Exception e) {
            logger.error("上传异常" +e.getMessage());
            return ProUtil.getJSONString(1,"上传异常");
        }
    }

}
