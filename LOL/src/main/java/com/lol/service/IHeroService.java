package com.lol.service;

import com.lol.domain.Hero;
import com.lol.vo.HeroMsgBean;
import com.lol.vo.PageBean;

import java.util.List;

public interface IHeroService {
    public List<Hero> findAllHero();

    public Hero findByName(String name);

    public List<Hero> findByCamp(String camp);

    public PageBean<Hero> findHeroPage(int page);

    public Hero findByHeroId(int id);

    public void deleteByHeroId(int id);

    public void addHero(Hero hero);

    public void updateHeroById(Hero hero);

    public HeroMsgBean findHeroInfo(int id);
}
