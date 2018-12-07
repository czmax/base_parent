package com.turbomax.show.common.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Chen
 * @created 2018-12-07-14:48.
 */
public class CustomUserService implements UserDetailsService {

    @Inject
    private UserDao userDao;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 生成当前登陆用户的token
        String token = Uuid.getUUid();
        // 将用户信息使用token保存到redis中并在一个小时以后过期
        redisCache.setObject(token, userMapper.userToBase(user));
        // 设置token的过期时间为3600秒
        redisCache.expire(token, 3600);
        // 将生成的token重新放回页面
        UserInfoUtil.getRequest().getSession().setAttribute("token", token);
        // 获取当前登陆用户的真实IP地址
        String IP = IPUtil.getIpAddress(UserInfoUtil.getRequest());
        // 根据IP和token设置当前登陆的用户
        redisCache.setObject(IP + "-" + token, userMapper.userToBase(user));
        // 设置token的过期时间为3600秒
        redisCache.expire(IP + "-" + token, 3600);
        // 用户登陆以后更新用户的最迟登陆时间
        user.setLastLoginDate(new Date());
        // 自定义错误的文章说明的地址：http://blog.csdn.net/z69183787/article/details/21190639?locationNum=1&fps=1
        if (user.getState().equalsIgnoreCase("0")) {
            throw new LockedException("用户账号被冻结，无法登陆请联系管理员！");
        }

        return user;
    }


}
