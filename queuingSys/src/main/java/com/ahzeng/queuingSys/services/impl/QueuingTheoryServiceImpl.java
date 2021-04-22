package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.QueuingTheoryMapper;
import com.ahzeng.queuingSys.pojo.QueuingTheory;
import com.ahzeng.queuingSys.services.QueuingTheoryService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueuingTheoryServiceImpl implements QueuingTheoryService {
    @Autowired
    QueuingTheoryMapper queuingTheoryMapper;

    @Override
    public Result<QueuingTheory> QueuingTheorySelectByPrimaryKey(int id) {
        QueuingTheory queuingTheory = queuingTheoryMapper.selectByPrimaryKey(id);
        if (queuingTheory != null){
            return Result.success(queuingTheory);
        }
        return Result.error(CodeMsg.QueuingTheorySelectByPrimaryKey_ERROR);
    }

    @Override
    public CodeMsg QueuingTheoryUpdateByPrimaryKeySelective(QueuingTheory record) {
        int resultOfOperation = queuingTheoryMapper.updateByPrimaryKeySelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.QueuingTheoryUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.QueuingTheoryUpdateByPrimaryKeySelective_ERROR;
    }

    @Override
    public CodeMsg QueuingTheoryInsertSelective(QueuingTheory record) {
        int resultOfOperation = queuingTheoryMapper.insertSelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.QueuingTheoryInsertSelective_SUCCESS;
        }
        return CodeMsg.QueuingTheoryInsertSelective_ERROR;
    }
}
