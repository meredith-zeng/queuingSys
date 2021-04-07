package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.Worker;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;

public interface WorkerService {
    CodeMsg loginVerify(Worker record);
    Result userSelectByPrimaryKey(int id);
    Result userSelectAll();
    CodeMsg userUpdateByPrimaryKeySelective(Worker record);
    CodeMsg userInsertSelective(Worker record);
    CodeMsg userDeleteByPrimaryKey(Object key);
}
