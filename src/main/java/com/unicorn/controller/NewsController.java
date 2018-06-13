package com.unicorn.controller;

import com.unicorn.service.NewsService;
import com.unicorn.util.ProUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @RequestMapping(path = {"/image"}, method = {RequestMethod.GET})
    @ResponseBody
    public void getImage(@RequestParam("name") String imageName,
                         HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            StreamUtils.copy(new FileInputStream(new File(ProUtil.IMAGE_DIR + imageName)), response.getOutputStream());
        } catch (Exception e) {
            logger.error("load image failed" + e.getMessage());
        }
    }

    @RequestMapping(path = {"/uploadImage"}, method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImage(@RequestParam("file")MultipartFile file) {
        try {
            String fileUrl = newsService.saveImage(file);
            if (fileUrl == null) {
                return ProUtil.getJSONString(1, "upload image failed");
            }
            return ProUtil.getJSONString(0, fileUrl);
        } catch (Exception e) {
            logger.error("" + e.getMessage());
            return ProUtil.getJSONString(1, "upload failed");
        }
    }
}
