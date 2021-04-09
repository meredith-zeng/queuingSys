package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.TableOfHallMapper;
import com.ahzeng.queuingSys.pojo.TableOfHall;
import com.ahzeng.queuingSys.services.TableOfHallService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.TableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class TableOfHallServiceImpl implements TableOfHallService {
    @Autowired
    private TableOfHallMapper tableOfHallMapper;
    //按条件查询桌子
    @Override
    public Result<List<TableVo>> tableSelect(TableOfHall record) {
        List<TableOfHall> tableOfHallList = tableOfHallMapper.select(record);
        if (tableOfHallList.size() > 0){
            List<TableVo> tableVoList = new LinkedList<>();
            for(int i = 0; i < tableOfHallList.size();i++){
                TableVo tableVo = new TableVo();
                tableVo.setTableIndex(tableOfHallList.get(i).getTableIndex());
                tableVo.setTableId(tableOfHallList.get(i).getTableId());
                tableVo.setTableType(tableOfHallList.get(i).getTableType());
                //暂时未实现该跨表功能，暂时全部用未占用代替
                tableVo.setUsingStatus(0);
                tableVoList.add(i, tableVo);
            }
            return Result.success(tableVoList);
        }
        return Result.error(CodeMsg.tableSelect_ERROR);
    }
    //
    @Override
    public Result<TableVo> tableSelectByPrimaryKey(int id) {
        TableOfHall tableOfHall = tableOfHallMapper.selectByPrimaryKey(id);
        if (tableOfHall != null){
            TableVo tableVo = new TableVo();
            tableVo.setTableType(tableOfHall.getTableType());
            tableVo.setTableId(tableOfHall.getTableId());
            tableVo.setTableIndex(tableOfHall.getTableIndex());
            //暂时未实现该跨表功能，暂时全部用未占用代替
            tableVo.setUsingStatus(0);
            return Result.success(tableVo);
        }
        return Result.error(CodeMsg.tableSelectByPrimaryKey_ERROR);
    }

    //根据主键修改指定桌子的信息
    @Transactional
    @Override
    public CodeMsg tableUpdateByPrimaryKeySelective(TableOfHall record) {
        if (tableOfHallMapper.updateByPrimaryKeySelective(record) == 1){
            return CodeMsg.tableUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.tableUpdateByPrimaryKeySelective_ERROR;
    }

    //新增桌子
    @Transactional
    @Override
    public CodeMsg tableInsertSelective(TableOfHall record) {
        if (tableOfHallMapper.insertSelective(record) == 1){
            return CodeMsg.tableUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.tableUpdateByPrimaryKeySelective_ERROR;
    }

    //根据主键删除桌子
    @Transactional
    @Override
    public CodeMsg tableDeleteByPrimaryKey(Object key) {
        int resultOfOperation = tableOfHallMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.tableDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.tableDeleteByPrimaryKey_ERROR;
    }

}
