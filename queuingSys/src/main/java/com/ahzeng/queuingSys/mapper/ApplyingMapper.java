package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.Applying;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "ApplyingMapper")
public interface ApplyingMapper extends Mapper<Applying> {

}