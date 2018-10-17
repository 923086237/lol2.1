package com.lol.controller;

import com.lol.domain.JsonBean;
import com.lol.domain.Skin;
import com.lol.service.ISkinService;
import com.lol.utils.JsonBeanUtil;
import com.lol.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SkinController {

    @Autowired
    private ISkinService skinService;


    @RequestMapping(value = "findSkinAll",method = RequestMethod.GET)
    @ResponseBody
    public JsonBean findAllSkin(){
        List<Skin> list = skinService.findSkinAll();
        return JsonBeanUtil.w(1,list);
    }

    @RequestMapping(value = "findSkinPage",method = RequestMethod.GET)
    @ResponseBody
    public JsonBean findSkinPage(@PathVariable("page") int page){
        PageBean<Skin> info = skinService.findSkinByPage(page);
        return JsonBeanUtil.w(1,info);

    }

}
