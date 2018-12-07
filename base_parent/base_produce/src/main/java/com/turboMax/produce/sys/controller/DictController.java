package com.turboMax.produce.sys.controller;

import com.turboMax.model.entity.Dict;
import com.turboMax.model.entity.QueryDict;
import com.turboMax.produce.common.base.constant.SystemStaticConst;
import com.turboMax.produce.common.base.controller.GenericController;
import com.turboMax.produce.common.base.service.GenericService;
import com.turboMax.produce.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chen
 * @created 2018-12-07-13:47.
 */
@RestController
@RequestMapping("/dict")
public class DictController extends GenericController<Dict, QueryDict> {

    @Autowired
    private DictService dictService;

    @Override
    protected GenericService getService() {
        return dictService;
    }

    /**
     * 功能描述：将字典数据初始化到前端js中
     *
     * @return
     */
    @RequestMapping(value = "/loadDict", method = RequestMethod.POST)
    public Map<String, Object> loadDict() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Dict> dictList = dictService.query(new QueryDict("1"));
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put("data", dictList);
        return result;
    }


}
