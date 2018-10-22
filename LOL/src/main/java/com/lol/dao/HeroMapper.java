package com.lol.dao;

import com.lol.domain.Hero;
import com.lol.vo.HeroMsgBean;

import java.util.List;
import java.util.Map;

public interface HeroMapper {
    /**
     * 查询所有hero
     * @return hero列表
     */
    public List<Hero> findAllHero();

    /**
     * 根据name查询hero
     * @param name
     * @return 单个hero
     */
    public Hero findByHeroName(String name);

    /**
     * 根据地区查询heros
     * @param camp 地区
     * @return hero的列表
     */
    public List<Hero> findByHeroCamp(String camp);

    /**
     * 分页展示
     * @param info
     * @return
     */
    public List<Hero> findAllHeroLimit(Map<String, Object> info);

    /**
     * 查询hero个数
     * @return 数量
     */
    public int count();


    /**
     * 根据id查询英雄
     * @param id
     * @return
     */
    public Hero findByHeroId(int id);

    /**
     * 增加英雄
     * @param hero
     */
    public void addHero(Hero hero);


    /**
     * 根据ID删除英雄
     * @param id
     */
    public void delete(int id);

    /**
     * 修改英雄
     * @param hero
     */
    public void updateHero(Hero hero);

    /**
     * 根据ID查询英雄详细信息
     * @param id
     * @return
     */
    public HeroMsgBean findHeroMsgById(int id);
}
