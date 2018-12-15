package com.max.code.sys.common.dao;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Chen
 * @created 2018-12-15-12:33.
 */
public interface IBaseMapper<T> extends MySqlMapper<T>, Mapper<T>, IdsMapper<T>, ConditionMapper<T> {
}
