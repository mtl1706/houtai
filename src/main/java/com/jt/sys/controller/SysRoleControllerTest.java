/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SysRoleControllerTest
 * Author:   tedu
 * Date:     2018/5/13 19:37
 * Description: 此类为测试类
 * History:
 * <author>          <time&date>          <version>          <desc>
 * 作者姓名           修改时间             版本号             描述
 */
package com.jt.sys.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 〈一句话功能简述〉<br> 
 * 〈此类为测试类〉
 *
 * @author tedu
 * @create 2018/5/13
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-configs.xml")
@WebAppConfiguration
public class SysRoleControllerTest {
   protected MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void updateObjectTest() throws Exception {
        String responseString = mockMvc.perform(
                get("/role/doUpdateObject")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id","44")
                .param("name","M")
        ).andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("--返回的json = "+responseString);
    }
}