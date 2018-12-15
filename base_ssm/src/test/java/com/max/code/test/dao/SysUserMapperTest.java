package com.max.code.test.dao;

import com.github.pagehelper.PageHelper;
import com.max.code.sys.dao.SysUserMapper;
import com.max.code.sys.entity.SysUser;
import com.max.code.test.util.SpringContextUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen
 * @created 2018-12-15-12:53.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml","classpath:spring/springMvc.xml"})
public class SysUserMapperTest {
    private SysUserMapper sysUserMapper;

    @Before
    public void setUp() throws Exception{
        this.sysUserMapper= SpringContextUtil.getBean(SysUserMapper.class);
    }

    @Test
    public void selectOne(){
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(new Integer(5));
        System.out.println("sysUser的值是：---" + sysUser.getUserName() + "，当前方法=SysUserMapperTest.selectOne()");
    }
    /**
     * select * from test where id in (?,?,?,?)
     */
    @Test
    public void selectByExample(){
        Example example= new Example(SysUser.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        example.createCriteria().andIn("id",ids);
        example.setOrderByClause("id desc");
        List<SysUser> sysUsers = this.sysUserMapper.selectByExample(example);
        System.out.println("sysUsers的值是：---" + sysUsers + "，当前方法=SysUserMapperTest.selectByExample()");
    }

    /**
     * Tests pagination
     */
    @Test
    public void selectByPage(){
        PageHelper.startPage(1,2);
        List<SysUser> sysUsers = this.sysUserMapper.selectAll();
        for (SysUser sysUser: sysUsers
             ) {
            System.out.println("sysUser的值是：---" + sysUser + "，当前方法=SysUserMapperTest.selectByPage()");

        }
    }

    @Test
    public void addTestData(){
        List<SysUser> sysUsers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setId(i+5);
            sysUsers.add(sysUser);
        }
        int result = this.sysUserMapper.insertList(sysUsers);
        System.out.println("result的值是：---" + result + "，当前方法=SysUserMapperTest.addTestData()");
    }
}
