package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.QueuingExcel;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "QueuingExcelMapper")
public interface QueuingExcelMapper extends Mapper<QueuingExcel> {

}