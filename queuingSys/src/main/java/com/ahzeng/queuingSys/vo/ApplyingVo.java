package com.ahzeng.queuingSys.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
@Data
public class ApplyingVo {
    private Integer queuingOrderId;
    private Integer guestId;

}
