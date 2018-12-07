package com.turboMax.auth.controller;

import com.turboMax.model.entity.Identify;
import com.turboMax.model.entity.User;
import com.turboMax.model.util.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 这里重点和大家讲解下鉴权中心的鉴权的逻辑，首先用户在登陆成功的时候，系统会获取当前登陆用户的IP与相应的token
 * 组合作为key，用户登陆信息作为value保存在redis内存数据库中，每次用户通过路由网关调用的请求都会携带token信息，
 * 路由网关获取用户的token信息以及真实IP调用鉴权中心鉴权接口，鉴权中心根据路由网关提供的token和真实IP去redis内存数据库去查找我们的用户信息，
 * 若查到则表面该用户已经登陆成功了，那么该用户就可以接着走正常的业务流程，反之则告知用户没有权限访问，
 * 该鉴权中心只验证了用户是否登陆，但是并没有根据用户的权限进行拦截，因此大家可以在此工程的基础上对权限进行拦截。
 *
 * @author Chen
 * @created 2018-12-06-22:04.
 */

@RestController
public class AuthController {
    @Autowired
    private RedisCache redisCache;

    @PostMapping("/identify")
    public Map<String, Object> identify(@RequestBody Identify identify) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", false);
        result.put("msg", "用户非法登陆");
        if (identify != null && identify.getToken() != null && !identify.getToken().equals("") && identify.getIp() != null && !identify.getIp().equals("")) {
            System.out.println("鉴权中心收到的token的值是：" + identify.getIp() + "--" + identify.getToken());
            User user = redisCache.getObject(identify.getIp() + "-" + identify.getToken(), User.class);
            if (user == null) {
                result.put("result", false);
                result.put("msg", "用户未登陆，请重新登陆以后再操作！");
                return result;
            }
            result.put("result", true);
            result.put("msg", "权限鉴定通过");
        }
        return result;
    }


}
