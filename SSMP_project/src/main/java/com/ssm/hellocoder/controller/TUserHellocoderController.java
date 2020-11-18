package com.ssm.hellocoder.controller;

import com.ssm.hellocoder.entity.TUserHellocoder;
import com.ssm.hellocoder.service.TUserHellocoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * (TUserHellocoder)表控制层
 *
 * @author HaC
 * @since 2020-05-29 00:47:08
 */
@Controller
@RequestMapping("/HelloCoder")
public class TUserHellocoderController {
    /**
     * 服务对象
     */
    @Resource
    private TUserHellocoderService tUserHellocoderService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectUser")
    public ModelAndView selectOne(@RequestParam(value = "id") Integer id) {
        ModelAndView md = new ModelAndView("index");
        TUserHellocoder userHellocoder = tUserHellocoderService.queryById(id);
//        把数据存到ModelAndView，给前端
        md.addObject("user", userHellocoder);
        return md;
    }

}