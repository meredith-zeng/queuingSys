package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.pojo.Applying;
import com.ahzeng.queuingSys.services.ApplyingService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.ApplyingVo;

import java.util.List;

public class ApplyingServiceImpl implements ApplyingService {


    @Override
    public Result<List<ApplyingVo>> ApplyingSelect(Applying record) {
        return null;
    }

    @Override
    public Result<List<ApplyingVo>> ApplyingSelectAll() {
        return null;
    }

    @Override
    public Result<ApplyingVo> ApplyingSelectByPrimaryKey(int id) {
        return null;
    }

    @Override
    public CodeMsg ApplyingUpdateByPrimaryKeySelective(Applying record) {
        return null;
    }

    @Override
    public CodeMsg ApplyingInsertSelective(Applying record) {
        return null;
    }

    @Override
    public CodeMsg ApplyingDeleteByPrimaryKey(Object key) {
        return null;
    }
}
