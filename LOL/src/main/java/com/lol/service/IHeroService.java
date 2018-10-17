package com.lol.service;

import com.lol.domain.Hero;
import com.lol.vo.PageBean;

import java.util.List;

public interface IHeroService {
    public List<Hero> findAllHero();

    public Hero findByName(String name);

    public List<Hero> findByCamp(String camp);

    public PageBean<Hero> findHeroPage(int page);
}
