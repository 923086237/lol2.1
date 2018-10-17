package com.lol.manager;

import com.lol.dao.SkinMapper;

import com.lol.domain.Skin;
import com.lol.service.ISkinService;
import com.lol.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkinService implements ISkinService {

    @Autowired
    private SkinMapper skinMapper;

    @Override
    public List<Skin> findSkinAll() {
        return skinMapper.findAllSkin();
    }

    @Override
    public PageBean<Skin> findSkinByPage(int page) {
        PageBean<Skin> pageInfo = new PageBean<>();
        pageInfo.setCurrentPage(page);

        //获取表中的总数
        int count = skinMapper.count();

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

        List<Skin> list = skinMapper.findAllSkinLimit(map);
        pageInfo.setPageInfos(list);
        pageInfo.setCount(count);
        return pageInfo;
    }
}
