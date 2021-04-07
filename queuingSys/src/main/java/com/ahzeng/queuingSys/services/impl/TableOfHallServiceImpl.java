package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.TableOfHallMapper;
import com.ahzeng.queuingSys.pojo.TableOfHall;
import com.ahzeng.queuingSys.services.TableOfHallService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TableOfHallServiceImpl implements TableOfHallService {
    @Autowired
    private TableOfHallMapper tableOfHallMapper;
    //按条件查询桌子
    @Override
    public Result tableSelect(TableOfHall record) {
        List<TableOfHall> tableOfHallList = tableOfHallMapper.select(record);
        if (tableOfHallList.size() > 0){
            List<TableInfo> tableInfoList = new LinkedList<>();
            for(int i = 0; i < tableOfHallList.size();i++){
                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableIndex(tableOfHallList.get(i).getTableIndex());
                tableInfo.setTableId(tableOfHallList.get(i).getTableId());
                tableInfo.setTableType(tableOfHallList.get(i).getTableType());
                //暂时未实现该跨表功能，暂时全部用未占用代替
                tableInfo.setUsingStatus(0);
                tableInfoList.add(i, tableInfo);
            }
            return Result.success(tableInfoList);
        }
        return Result.error(CodeMsg.tableSelect_ERROR);
    }
    //
    @Override
    public Result tableSelectByPrimaryKey(int id) {
        TableOfHall tableOfHall = tableOfHallMapper.selectByPrimaryKey(id);
        if (tableOfHall != null){
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableType(tableOfHall.getTableType());
            tableInfo.setTableId(tableOfHall.getTableId());
            tableInfo.setTableIndex(tableOfHall.getTableIndex());
            //暂时未实现该跨表功能，暂时全部用未占用代替
            tableInfo.setUsingStatus(0);
            return Result.success(tableInfo);
        }
        return Result.error(CodeMsg.tableSelectByPrimaryKey_ERROR);
    }

    //根据主键修改指定桌子的信息
    @Override
    public CodeMsg tableUpdateByPrimaryKeySelective(TableOfHall record) {
        if (tableOfHallMapper.updateByPrimaryKeySelective(record) == 1){
            return CodeMsg.tableUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.tableUpdateByPrimaryKeySelective_ERROR;
    }

    //新增桌子
    @Override
    public CodeMsg tableInsertSelective(TableOfHall record) {
        if (tableOfHallMapper.insertSelective(record) == 1){
            return CodeMsg.tableUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.tableUpdateByPrimaryKeySelective_ERROR;
    }

    //根据主键删除桌子
    @Override
    public CodeMsg tableDeleteByPrimaryKey(Object key) {
        int resultOfOperation = tableOfHallMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.tableDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.tableDeleteByPrimaryKey_ERROR;
    }

}