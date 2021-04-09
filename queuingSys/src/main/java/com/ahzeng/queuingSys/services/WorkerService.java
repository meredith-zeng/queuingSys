package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.Worker;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.WorkerVo;

import java.util.List;

public interface WorkerService {
    CodeMsg loginVerify(Worker record);
    Result<WorkerVo> userSelectByPrimaryKey(int id);
    Result<List<WorkerVo>>userSelectAll();
    CodeMsg userUpdateByPrimaryKeySelective(Worker record);
    CodeMsg userInsertSelective(Worker record);
    CodeMsg userDeleteByPrimaryKey(Object key);
}
