package com.turbomax.show.common.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring-security登陆的密码进行MD5加密传到数据库
 *
 * @author Chen
 * @created 2018-12-07-14:45.
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(rawPassword.toString(), "hyll");
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.isPasswordValid(encodedPassword, rawPassword.toString(), "hyll");
    }


}
