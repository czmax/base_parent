package com.max.code.sys.common.service.impl;

import com.max.code.sys.common.dao.IBaseMapper;
import com.max.code.sys.common.exception.IBaseException;
import com.max.code.sys.common.service.IBaseService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Chen
 * @created 2018-12-15-12:43.
 */
public abstract class IBaseServiceImpl<T> implements IBaseService<T> {

    private static final Logger log = LoggerFactory.getLogger(IBaseService.class);

    @Autowired
    protected IBaseMapper<T> mapper;

    private Class<T> modelClass;

    public IBaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T model) {
        mapper.insertSelective(model);
    }
    @Override
    public void save(List<T> models) {
        mapper.insertList(models);
    }
    @Override
    public void deleteById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
    @Override
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }
    @Override
    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }
    @Override
    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
    @Override
    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }
    @Override
    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }
    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }
    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            //true 代表能通过访问访问该字段
            field.setAccessible(true);
            field.set(model, value);

            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            log.info("IBaseService have reflect erors = {}", e.getMessage());
            throw new IBaseException(e.getMessage());
        }
    }
}


