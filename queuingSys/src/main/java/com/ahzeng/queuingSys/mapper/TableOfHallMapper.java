package com.ahzeng.queuingSys.mapper;

import com.ahzeng.queuingSys.pojo.TableOfHall;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "TableOfHallMapper")
public interface TableOfHallMapper extends Mapper<TableOfHall> {
    @Select("select COUNT(Table_Type) from TableOfHall where Table_Type = #{Table_Type}")
    Integer countTableNumber(String Table_Type);

    @Select("select COUNT(Table_Type) from TableOfHall")
    Integer countAllTableNumber();
}