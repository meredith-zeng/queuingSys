package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.OrderForm;
import com.ahzeng.queuingSys.pojo.Ordering;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "OrderingMapper")
public interface OrderingMapper extends Mapper<Ordering> {

}