package com.lol.service;

import com.lol.domain.Skin;
import com.lol.vo.PageBean;

import java.util.List;
import java.util.Map;

public interface ISkinService {

    public List<Skin> findSkinAll();

    public PageBean<Skin> findSkinByPage(int page);

}
