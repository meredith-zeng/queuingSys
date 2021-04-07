package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.Worker;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "WorkerMapper")
public interface WorkerMapper extends Mapper<Worker> {

}