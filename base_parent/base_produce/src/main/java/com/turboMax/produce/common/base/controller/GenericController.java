package com.turboMax.produce.common.base.controller;

import com.turboMax.model.common.Page;
import com.turboMax.model.common.QueryBase;
import com.turboMax.model.util.json.JsonHelper;
import com.turboMax.produce.common.base.constant.SystemStaticConst;
import com.turboMax.produce.common.base.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericController<T, Q extends QueryBase> {

    // 抽象方法
    protected abstract GenericService<T, Q> getService();

    /**
     * 功能描述：根据ID来获取数据
     *
     * @param id
     * @return
     */
    @PostMapping("/getById")
    public Map<String, Object> getById(int id) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        T t = getService().getById(id);
        if (t == null) {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
            result.put(SystemStaticConst.MSG, "获取数据失败！");
            result.put("entity", t);
        } else {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
            result.put(SystemStaticConst.MSG, "获取数据成功！");
            result.put("entity", t);
        }
        return result;
    }


    /**
     * 功能描述：获取数据
     *
     * @param entity
     * @return
     */
    @PostMapping("/get")
    public Map<String, Object> get(@RequestBody T entity) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        T t = getService().get(entity);
        if (t == null) {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
            result.put(SystemStaticConst.MSG, "获取数据失败！");
            result.put("entity", t);
        } else {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
            result.put(SystemStaticConst.MSG, "获取数据成功！");
            result.put("entity", t);
        }
        return result;
    }


    /**
     * 功能描述：保存数据
     *
     * @param entity
     * @return
     */
    @PostMapping( "/save")
    public Map<String, Object> save(@RequestBody T entity) throws Exception {
        boolean success = getService().save(entity);
        Map<String, Object> result = new HashMap<String, Object>();
        if (success == true) {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
            result.put(SystemStaticConst.MSG, "增加数据成功！");
            result.put("entity", entity);
        } else {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
            result.put(SystemStaticConst.MSG, "增加数据失败！");
        }
        return result;
    }

    /**
     * 功能描述：更新数据
     *
     * @param entity
     * @return
     */
    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody T entity) throws Exception {
        boolean success = getService().update(entity);
        Map<String, Object> result = new HashMap<String, Object>();
        if (success == true) {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
            result.put(SystemStaticConst.MSG, "更新数据成功！");
            result.put("entity", entity);
        } else {
            result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
            result.put(SystemStaticConst.MSG, "更新数据失败！");
        }
        return result;
    }

    /**
     * 功能描述：实现删除数据
     *
     * @param entity
     * @return
     */
    @DeleteMapping("/remove")
    public Map<String, Object> remove(@RequestBody T entity) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        getService().delete(entity);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put(SystemStaticConst.MSG, "删除数据成功！");
        return result;
    }


    /**
     * 功能描述：实现批量删除的记录
     *
     * @param json
     * @return
     */
    @DeleteMapping("/removeBath")
    public Map<String, Object> removeBath(String json) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        getService().removeBath((List<T>) JsonHelper.toList(json, (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]));
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put(SystemStaticConst.MSG, "删除数据成功！");
        return result;
    }

    /**
     * 功能描述：获取分页的数据
     *
     * @param entity
     * @return
     */
    @PostMapping("/list")
    public Map<String, Object> list(@RequestBody Q entity) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page page = getService().findByPage(entity);
        result.put("totalCount", page.getTotal());
        result.put("result", page.getRows());
        return result;
    }

    /**
     * 功能描述：判断当前的元素是否已经存在
     *
     * @param entity
     * @return
     */
    @PostMapping("/isExist")
    public Map<String, Object> isExist(@RequestBody Q entity) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (getService().query(entity).size() > 0) {
            result.put("valid", false);
        } else {
            result.put("valid", true);
        }
        return result;
    }


}
