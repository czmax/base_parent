package com.max.code.test.service;

import com.max.code.sys.entity.SysUser;
import com.max.code.sys.service.SysUserService;
import com.max.code.test.util.SpringContextUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author Chen
 * @created 2018-12-15-13:01.
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml", "classpath:spring/springMvc.xml"})
public class SysUserServiceTest {

    private SysUserService sysUserService;

    @Before
    public void setUp() throws Exception {
        this.sysUserService = SpringContextUtil.getBean(SysUserService.class);
    }

    @Test
    public void selectOne() {
        SysUser sysUser = sysUserService.findById(new Integer(5));
        System.out.println("sysUser的值是：---" + sysUser + "，当前方法=SysUserServiceTest.selectOne()");
    }

    @Test
    public void findBy() {
        SysUser sysUser = sysUserService.findBy("userName", "admin");
        System.out.println("sysUser的值是：---" + sysUser + "，当前方法=SysUserServiceTest.findBy()");
    }

    @Test
    public void findByIds() {
        List<SysUser> sysUsers = sysUserService.findByIds("1,2,3,4,5");
        for (SysUser sysUser : sysUsers) {
            System.out.println("sysUser的值是：---" + sysUser + "，当前方法=SysUserServiceTest.findByIds()");
        }

    }

}
