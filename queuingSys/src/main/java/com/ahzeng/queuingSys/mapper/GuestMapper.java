package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.Guest;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "GuestMapper")
public interface GuestMapper extends Mapper<Guest> {

}