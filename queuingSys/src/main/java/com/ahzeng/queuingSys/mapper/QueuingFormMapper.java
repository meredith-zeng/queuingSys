package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.QueuingForm;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "QueuingFormMapper")
public interface QueuingFormMapper extends Mapper<QueuingForm> {
    // QueuingForm需要统计状态为“排队中”的数据
    @Select("select COUNT(Queuing_Status) from QueuingForm where Queuing_Status = '排号中' ")
    Integer countQueuingGuestNumber();


}