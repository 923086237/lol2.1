package com.lol.controller;

import com.lol.domain.Hero;
import com.lol.domain.JsonBean;
import com.lol.service.IHeroService;
import com.lol.utils.JsonBeanUtil;
import com.lol.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HeroController {

    @Autowired
    private IHeroService heroService;

    @RequestMapping(value = "findAllHero",method = RequestMethod.GET)
    @ResponseBody
    public JsonBean findAll(){
        try {
           List<Hero> list = heroService.findAllHero();
            return JsonBeanUtil.w(0,list);
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

    // 上传图片
    @RequestMapping(value="/heroPhotoupload", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> photoupload(@RequestParam("file") MultipartFile file) {

        String fName = file.getOriginalFilename()+(new Date().getTime());
        Map<String, Object> map = new HashMap<>();
        //保存图片的目录
        String path = " ";
        File fi = new File(path);
        //如果目录不存在，创建
        if(!fi.exists()){
            fi.mkdir();
        }
        File f = new File(path, fName);
        try {
            //上传文件
            file.transferTo(f);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        map.put("code", 0);// 针对layui的表格，0表示成功
        map.put("msg", "");
        map.put("data", fName);
        return map;
    }

    @RequestMapping(value = "HeroAdd", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean addHero(String title, String name, String sort, String camp, String introduce, String image, String price){
        Hero hero = new Hero();
        BigDecimal bd=new BigDecimal(price);
        hero.setTitle(title);
        hero.setName(name);
        hero.setSort(sort);
        hero.setCamp(camp);
        hero.setIntroduce(introduce);
        hero.setImage(image);
        hero.setPrice(bd);

        heroService.addHero(hero);
        return JsonBeanUtil.w(0,null);
    }


    @RequestMapping(value = "deleteHero",method = RequestMethod.GET)
    @ResponseBody
    public JsonBean delHero(int id){
        try {
            heroService.deleteByHeroId(id);
            return JsonBeanUtil.w(0,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonBeanUtil.w(1,e.getMessage());
        }
    }

    @RequestMapping(value = "updateHeroById", method = RequestMethod.PUT)
    @ResponseBody
    public JsonBean updateHero( String id,String title, String name, String sort, String camp, String introduce, String image, String price){
        Hero hero = heroService.findByHeroId(Integer.parseInt(id));
        BigDecimal bd=new BigDecimal(price);
        hero.setTitle(title);
        hero.setName(name);
        hero.setSort(sort);
        hero.setCamp(camp);
        hero.setIntroduce(introduce);
        hero.setImage(image);
        hero.setPrice(bd);
        try {
            heroService.updateHeroById(hero);
            return JsonBeanUtil.w(0,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonBeanUtil.w(1,e.getMessage());
        }
    }

    @RequestMapping(value = "findHeroById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonBean findInfoHero(String id){
        heroService.findHeroInfo(Integer.parseInt(id));
        return JsonBeanUtil.w(0,null);
    }

}
