package com.ahzeng.queuingSys.vo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class GuestVo {

    private Integer guestId;

    private String phoneNumber;

    private String lastName;

    private String gender;
}
