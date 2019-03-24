package com.llf.springboot.controller;

import com.llf.springboot.common.responseUtil.CmpException;
import com.llf.springboot.common.responseUtil.ErrorCodeAndMsg;
import com.llf.springboot.common.responseUtil.Response;
import com.llf.springboot.model.User;
import com.llf.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PhychoLee on 2016/10/13.
 * Description:
 */
@RestController
public class HelloController {
    @Autowired
    private UserService userService;
    @Autowired
    StringRedisTemplate redisTemplate;
    //@Autowired
    //RedisTemplate redisTemplate;

    @RequestMapping("/")
    public Response getUser() throws Exception {
        User user =null;
        try {
            user = userService.findById(1);
            //redisTemplate.opsForValue().set("data", String.valueOf(user));
            if(null == user) {
                throw new CmpException(ErrorCodeAndMsg.cmp_user_does_not_exist);
            }
            return new Response(user);
        } catch (Exception e) {
            if(e instanceof CmpException){
                throw e;
            }else {
                throw new CmpException(ErrorCodeAndMsg.Network_error);
            }
        }
    }


}
