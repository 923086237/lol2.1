package com.lol.manager;

import com.lol.dao.HeroMapper;
import com.lol.domain.Hero;
import com.lol.service.IHeroService;
import com.lol.vo.HeroMsgBean;
import com.lol.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HeroService implements IHeroService {


    @Autowired
    private HeroMapper heroMapper;

    @Override
    public List<Hero> findAllHero() {

        return heroMapper.findAllHero();
    }

    @Override
    public Hero findByName(String name) {
        return heroMapper.findByHeroName(name);
    }

    @Override
    public List<Hero> findByCamp(String camp) {
        return heroMapper.findByHeroCamp(camp);

    }

    @Override
    public PageBean<Hero> findHeroPage(int page) {
        PageBean<Hero> pageInfo = new PageBean<>();
        pageInfo.setCurrentPage(page);

        //获取表中的总数
        int count = heroMapper.count();

        //根据总数计算页数

        if (count % pageInfo.getPageSize() == 0){
            pageInfo.setTotalPage(count / pageInfo.getPageSize());
        }else{
            pageInfo.setTotalPage(count / pageInfo.getPageSize() + 1);
            System.out.println("total: " + count / pageInfo.getPageSize());
        }
        // 根据页码计算分页查询时的开始索引
        int index = (page - 1) * pageInfo.getPageSize();
        Map<String, Object> map = new HashMap<>();
        map.put("index", index);
        map.put("size", pageInfo.getPageSize());

        List<Hero> list = heroMapper.findAllHeroLimit(map);
        pageInfo.setPageInfos(list);
        pageInfo.setCount(count);

        return pageInfo;
    }



    @Override
    public Hero findByHeroId(int id) {
       return heroMapper.findByHeroId(id);
    }

    @Override
    public void deleteByHeroId(int id) {
        if (heroMapper.findByHeroId(id) != null){
            heroMapper.delete(id);
        }else{
            throw new RuntimeException("用户不存在, 无法删除");
        }

    }

    @Override
    public void addHero(Hero hero) {
      if(heroMapper.findByHeroId(hero.getId())  != null){
          heroMapper.addHero(hero);
      }else{
          throw new RuntimeException("用户已存在，无法添加");
      }
    }

    @Override
    public void updateHeroById(Hero hero) {
        if (heroMapper.findByHeroId(hero.getId()) != null){
            heroMapper.updateHero(hero);
        }else{
            throw new RuntimeException("用户不存在，无法修改");
        }
    }

    @Override
    public HeroMsgBean findHeroInfo(int id) {
        return heroMapper.findHeroMsgById(id);
    }


}
