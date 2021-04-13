package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.QueuingForm;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "QueuingFormMapper")
public interface QueuingFormMapper extends Mapper<QueuingForm> {

}