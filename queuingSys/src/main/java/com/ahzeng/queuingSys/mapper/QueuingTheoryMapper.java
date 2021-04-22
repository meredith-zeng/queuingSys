package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.QueuingForm;
import com.ahzeng.queuingSys.pojo.QueuingTheory;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "QueuingTheoryMapper")
public interface QueuingTheoryMapper extends Mapper<QueuingTheory> {

}
