package com.ailbb.aws.controller;

import com.ailbb.ajj.$;
import com.ailbb.ajj.entity.$Result;
import com.ailbb.aws.aop.AilbbAopType;
import com.ailbb.aws.mybatis.mapper.AilbbMapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by Wz on 2017/7/18.
 */
@Controller
public class AilbbController {
    @Autowired
    AilbbMapper ailbbMapper;

    /**
     * Mybatis方式1去查询数据。（Mapper方式）
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value={"/ailbb", "/ailbb/mapper", "/ailbb/mapper/java"})
    @ResponseBody
    @AilbbAopType(aopType = AilbbAopType.TypeHandler.QUERY)
    public $Result ailbbJavaMapper(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return $.result().addMessage("这是JavaMapper代码方式进行查询的结果")
                .setData(ailbbMapper.getAilbbByJavaMapper("zhangw"));
    }

    @Autowired
    SqlSessionDaoSupport sqlSessionDaoSupport;

    /**
     * Mybatis方式2去查询数据。（XML配置方式）
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value={"/ailbb/xml", "/ailbb/mapper/xml"})
    @ResponseBody
    @AilbbAopType(aopType = AilbbAopType.TypeHandler.QUERY)
    public $Result ailbbXmlMapper(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return $.result().addMessage("这是XmlMapper配置方式进行查询的结果")
                .setData(sqlSessionDaoSupport.getSqlSession().selectList("getAilbbByXmlMapper", Arrays.asList("zhangw")));
    }

    /**
     * Hello World
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value={"/hello"})
    public void hello(HttpServletRequest request, HttpServletResponse response) throws Exception {
        $.send(response, "Ailbb, Hello World!");
    }
}
