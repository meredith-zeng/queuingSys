package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.QueuingTheory;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;

public interface QueuingTheoryService {
    //根据id查询指定的排队数据
    Result<QueuingTheory> QueuingTheorySelectByPrimaryKey(int id);

    //根据主键修改指定的排队数据
    CodeMsg QueuingTheoryUpdateByPrimaryKeySelective(QueuingTheory record);

    //新增排队数据
    CodeMsg QueuingTheoryInsertSelective(QueuingTheory record);

}
