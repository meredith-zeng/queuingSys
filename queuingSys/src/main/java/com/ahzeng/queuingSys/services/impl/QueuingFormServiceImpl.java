package com.ahzeng.queuingSys.services.impl;


import com.ahzeng.queuingSys.mapper.QueuingFormMapper;
import com.ahzeng.queuingSys.pojo.QueuingForm;
import com.ahzeng.queuingSys.services.QueuingFormService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.QueuingFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueuingFormServiceImpl implements QueuingFormService {
    @Autowired
    QueuingFormMapper queuingFormMapper;


    @Override
    public Result<List<QueuingFormVo>> QueuingFormSelect(QueuingForm record) {
        return null;
    }

    @Override
    public Result<List<QueuingFormVo>> QueuingFormSelectAll(QueuingForm record) {
        return null;
    }

    @Override
    public Result<QueuingFormVo> QueuingFormSelectByPrimaryKey(int id) {
        return null;
    }

    @Override
    public CodeMsg QueuingFormUpdateByPrimaryKeySelective(QueuingForm record) {
        return null;
    }

    @Override
    public CodeMsg QueuingFormInsertSelective(QueuingForm record) {
        return null;
    }

    @Override
    public CodeMsg QueuingFormDeleteByPrimaryKey(Object key) {
        return null;
    }
}
