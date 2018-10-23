package com.unicorn.controller;

import com.unicorn.model.HostHolder;
import com.unicorn.service.LikeService;
import com.unicorn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
