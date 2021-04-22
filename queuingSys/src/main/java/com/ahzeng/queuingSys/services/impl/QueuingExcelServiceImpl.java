package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.QueuingExcelMapper;
import com.ahzeng.queuingSys.pojo.QueuingExcel;
import com.ahzeng.queuingSys.services.QueuingExcelService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.QueuingExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class QueuingExcelServiceImpl implements QueuingExcelService {
    @Autowired
    QueuingExcelMapper queuingExcelMapper;

    @Override
    public Result<QueuingExcelVo> QueuingExcelQueuingNumber(QueuingExcel record) {
        int i = record.getDateId();
        QueuingExcel queuingExcel = queuingExcelMapper.selectByPrimaryKey(record.getDateId());
        if(queuingExcel != null){
        QueuingExcelVo queuingExcelVo = new QueuingExcelVo();
            //当日各排队数
            int smallNumber, middleNumber, bigNumber = 0;
            smallNumber = queuingExcel.getSmallQueuingNumber();
            middleNumber = queuingExcel.getMiddleQueuingNumber();
            bigNumber = queuingExcel.getMiddleQueuingNumber();
                List<Integer> todayQueuingNumber = new LinkedList<>();
                todayQueuingNumber.add(smallNumber);
                todayQueuingNumber.add(middleNumber);
                todayQueuingNumber.add(bigNumber);


//            //假数据，等待排队论算法接入计算真数据
//            Date averageQueuingTime = queuingExcel.getAverageTime();
            queuingExcelVo.setTodayQueuingNumber(todayQueuingNumber);
            queuingExcelVo.setDataDate(queuingExcel.getDataDate());
            queuingExcelVo.setDateId(queuingExcel.getDateId());
            queuingExcelVo.setTodayQueuingTime( queuingExcel.getAverageTime());
             return Result.success(queuingExcelVo);
        }
        return Result.error(CodeMsg.QueuingExcelSelect_ERROR);
    }
    @Override
    public Result<QueuingExcelVo> QueuingExcelQueuingTime(QueuingExcel record){
        int id = record.getDateId();
        QueuingExcel queuingExcel = queuingExcelMapper.selectByPrimaryKey(record.getDateId());
        if (queuingExcel != null){
            QueuingExcelVo queuingExcelVo =  new QueuingExcelVo();

            List<QueuingExcel> queuingExcelList= queuingExcelMapper.selectAll();
            List<Date> allQueuingTime = new LinkedList<>();
            for(int i = 0; i < queuingExcelList.size(); i++){
                allQueuingTime.add(queuingExcelList.get(i).getAverageTime());
            }
            queuingExcelVo.setDataDate(queuingExcel.getDataDate());
            queuingExcelVo.setDateId(queuingExcel.getDateId());
            queuingExcelVo.setTodayQueuingTime( queuingExcel.getAverageTime());
            queuingExcelVo.setAllQueuingTime(allQueuingTime);

            return Result.success(queuingExcelVo);
        }
        return Result.error(CodeMsg.QueuingExcelSelect_ERROR);
    }

    @Override
    public CodeMsg QueuingExcelUpdateByPrimaryKeySelective(QueuingExcel record) {
        int resultOfOperation = queuingExcelMapper.updateByPrimaryKeySelective(record);
        if (resultOfOperation == 1 ){
            return CodeMsg.QueuingExcelUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.QueuingExcelUpdateByPrimaryKeySelective_ERROR;
    }

    @Override
    public CodeMsg QueuingExcelInsertSelective(QueuingExcel record) {
        int resultOfOperation = queuingExcelMapper.insertSelective(record);
        if (resultOfOperation == 1){
            return  CodeMsg.QueuingExcelInsertSelective_SUCCESS;
        }
        return  CodeMsg.QueuingExcelInsertSelective_ERROR;
    }

    @Override
    public CodeMsg QueuingExcelDeleteByPrimaryKey(QueuingExcel key) {
        int resultOfOperation = queuingExcelMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.QueuingExcelDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.QueuingExcelDeleteByPrimaryKey_ERROR;
    }


}
