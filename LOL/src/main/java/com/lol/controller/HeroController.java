package com.lol.controller;

import com.lol.domain.Hero;
import com.lol.domain.JsonBean;
import com.lol.service.IHeroService;
import com.lol.utils.JsonBeanUtil;
import com.lol.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeroController {

    @Autowired
    private IHeroService heroService;

    @RequestMapping(value = "findAllHero",method = RequestMethod.GET)
    @ResponseBody
    public JsonBean findAll(){
        try {
            heroService.findAllHero();
            return JsonBeanUtil.w(0,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonBeanUtil.w(1,e.getMessage());
        }
    }

    @RequestMapping(value = "page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean findHeroPage(@PathVariable("page") int page){
       PageBean<Hero> pageInfo = heroService.findHeroPage(page);
       return JsonBeanUtil.w(0, pageInfo);
    }
}
