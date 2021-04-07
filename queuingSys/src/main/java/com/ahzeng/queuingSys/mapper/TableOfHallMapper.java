package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.TableOfHall;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "TableOfHallMapper")
public interface TableOfHallMapper extends Mapper<TableOfHall> {

}