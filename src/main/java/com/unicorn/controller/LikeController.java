package com.unicorn.controller;

import com.unicorn.model.EntityType;
import com.unicorn.model.HostHolder;
import com.unicorn.service.LikeService;
import com.unicorn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LikeController {

    @Autowired
    HostHolder hostHolder;

    @Autowired
    LikeService likeService;

    @Autowired
    NewsService newsService;

//    @RequestMapping(path = {"/like"}, method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String like(@RequestParam("newId") int newsId) {
//        int userId = hostHolder.getUser().getId();
//        long likeCount = likeService.like(userId, EntityType.ENTITY_NEWS,newsId);
//    }
}
