package com.zzg.common.core.mapper;

import java.util.List;

import com.zzg.common.core.model.BaseEntity;

// 公共mapper 接口抽象
public interface BaseMapper<E extends BaseEntity> {
	int deleteByPrimaryKey(String sid);

    int insert(E record);

    E selectByPrimaryKey(String sid);

    List<E> selectAll();

    int updateByPrimaryKey(E record);
}
