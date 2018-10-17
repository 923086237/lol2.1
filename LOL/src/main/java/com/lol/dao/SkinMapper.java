package com.lol.dao;

import com.lol.domain.Skin;

import java.util.List;
import java.util.Map;

public interface SkinMapper {
    /**
     * 查询所有皮肤
     * @return 皮肤列表
     */
    public List<Skin> findAllSkin();

    /**
     * 分页
     * @param info
     * @return
     */
    public List<Skin> findAllSkinLimit(Map<String, Object> info);

    public int count();

}
