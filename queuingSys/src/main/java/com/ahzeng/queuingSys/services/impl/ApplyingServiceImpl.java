package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.ApplyingMapper;
import com.ahzeng.queuingSys.pojo.Applying;
import com.ahzeng.queuingSys.services.ApplyingService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.ApplyingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ApplyingServiceImpl implements ApplyingService {
    @Autowired
    ApplyingMapper applyingMapper;

    @Override
    public Result<List<ApplyingVo>> ApplyingSelect(Applying record) {
        List<Applying> applyingList = applyingMapper.select(record);
        if(applyingList.size() > 0){
            List<ApplyingVo> applyingVoList = new LinkedList<>();
            for(int i = 0; i < applyingList.size();i++){
                ApplyingVo applyingVo = new ApplyingVo();
                applyingVo.setGuestId(applyingList.get(i).getGuestId());
                applyingVo.setQueuingOrderId(applyingList.get(i).getQueuingOrderId());
                applyingVoList.add(i,applyingVo);
            }
            return Result.success(applyingVoList);
        }

        return Result.error(CodeMsg.ApplyingSelect_ERROR);
    }

    @Override
    public Result<List<ApplyingVo>> ApplyingSelectAll() {
        List<Applying> applyingList = applyingMapper.selectAll();
        if(applyingList.size() > 0){
            List<ApplyingVo> applyingVoList = new LinkedList<>();
            for(int i = 0; i < applyingList.size();i++){
                ApplyingVo applyingVo = new ApplyingVo();
                applyingVo.setGuestId(applyingList.get(i).getGuestId());
                applyingVo.setQueuingOrderId(applyingList.get(i).getQueuingOrderId());
                applyingVoList.add(i,applyingVo);
            }
            return Result.success(applyingVoList);
        }

        return Result.error(CodeMsg.ApplyingSelectAll_ERROR);
    }

    @Override
    public Result<ApplyingVo> ApplyingSelectByPrimaryKey(int id) {
        Applying applying = applyingMapper.selectByPrimaryKey(id);
        if (applying != null){
            ApplyingVo applyingVo = new ApplyingVo();
            applyingVo.setGuestId(applying.getGuestId());
            applyingVo.setQueuingOrderId(applying.getQueuingOrderId());
            return Result.success(applyingVo);
        }
        return Result.error(CodeMsg.ApplyingSelectByPrimaryKey_ERROR);
    }

    @Override
    public CodeMsg ApplyingUpdateByPrimaryKey(Applying record) {
        int resultOfOperation = applyingMapper.updateByPrimaryKey(record);
        if (resultOfOperation == 1){
            return CodeMsg.ApplyingUpdateByPrimaryKey_SUCCESS;
        }
        return  CodeMsg.ApplyingUpdateByPrimaryKey_ERROR;
    }

    @Override
    public CodeMsg ApplyingInsertSelective(Applying record) {
        int resultOfOperation = applyingMapper.insertSelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.ApplyingInsertSelective_SUCCESS;
        }
        return  CodeMsg.ApplyingInsertSelective_ERROR;
    }

    @Override
    public CodeMsg ApplyingDeleteByPrimaryKey(Object key) {
        int resultOfOperation = applyingMapper.deleteByPrimaryKey(key);
        if(resultOfOperation == 1){
            return CodeMsg.ApplyingDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.ApplyingDeleteByPrimaryKey_ERROR;
    }
}
