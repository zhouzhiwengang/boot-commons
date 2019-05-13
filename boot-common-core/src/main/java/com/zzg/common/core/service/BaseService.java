package com.zzg.common.core.service;

import java.util.List;
import com.zzg.common.core.model.BaseEntity;

// 公共方法抽象
public interface BaseService<E extends BaseEntity> {
	int deleteByPrimaryKey(String sid);

    int insert(E record);

    E selectByPrimaryKey(String sid);

    List<E> selectAll();

    int updateByPrimaryKey(E record);
}
