package com.turboMax.produce.sys.service;


import com.turboMax.model.entity.Dict;
import com.turboMax.model.entity.QueryDict;
import com.turboMax.produce.common.base.dao.GenericDao;
import com.turboMax.produce.common.base.service.GenericService;
import com.turboMax.produce.sys.dao.DictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author linzf
 **/
@Service
@Transactional(rollbackFor = {IllegalArgumentException.class})
public class DictService extends GenericService<Dict, QueryDict> {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private DictDao dictDao;

    @Override
    protected GenericDao<Dict, QueryDict> getDao() {
        return dictDao;
    }


}
