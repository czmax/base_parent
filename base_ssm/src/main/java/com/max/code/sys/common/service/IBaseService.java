package com.max.code.sys.common.service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public interface IBaseService<T> {

    void save(T model);

    void save(List<T> models);

    void deleteById(Integer id);

    /**
     * Batch delete, for exmaple ids "1, 2, 3, 4"
     *
     * @param ids
     */
    void deleteByIds(String ids);

    void update(T model);

    T findById(Integer id);

    List<T> findByIds(String ids);

    List<T> findByCondition(Condition condition);

    List<T> findAll();

    T findBy(String fieldName, Object value) throws TooManyResultsException;
}


