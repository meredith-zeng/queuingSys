package com.ahzeng.queuingSys.utils;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CodeMsg {

    private Integer code;
    private String msg;

    //员工模块
    public static final CodeMsg Login_SUCCESS = new CodeMsg(100, "登录成功");
    public static final CodeMsg Login_ERROR = new CodeMsg(101, "登录失败");
    public static final CodeMsg WorkerSelectByPrimaryKey_SUCCESS = new CodeMsg(102, "查询指定员工成功");
    public static final CodeMsg WorkerSelectByPrimaryKey_ERROR = new CodeMsg(103, "查询指定员工失败");
    public static final CodeMsg UserSelectAll_SUCCESS = new CodeMsg(104, "查询指定员工成功");
    public static final CodeMsg UserSelectAll_ERROR = new CodeMsg(105, "查询指定员工失败");
    public static final CodeMsg UserUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(106, "修改指定员工的信息成功");
    public static final CodeMsg UserUpdateByPrimaryKeySelective_ERROR = new CodeMsg(107, "修改指定员工的信息失败");
    public static final CodeMsg UserInsertSelective_SUCCESS = new CodeMsg(108, "新增员工成功");
    public static final CodeMsg UserInsertSelective_ERROR = new CodeMsg(109, "新增员工失败");
    public static final CodeMsg UserDeleteByPrimaryKey_SUCCESS = new CodeMsg(110, "删除员工成功");
    public static final CodeMsg UserDeleteByPrimaryKey_ERROR = new CodeMsg(111, "删除员工失败");


    //桌子管理模块
    public static final CodeMsg tableSelect_SUCCESS = new CodeMsg(200, "按条件查询桌子成功");
    public static final CodeMsg tableSelect_ERROR = new CodeMsg(201, "按条件查询桌子失败");
    public static final CodeMsg tableSelectByPrimaryKey_SUCCESS = new CodeMsg(202, "根据id查询桌子成功");
    public static final CodeMsg tableSelectByPrimaryKey_ERROR = new CodeMsg(203, "根据id查询桌子失败");
    public static final CodeMsg tableUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(204, "根据主键修改指定桌子的信息成功");
    public static final CodeMsg tableUpdateByPrimaryKeySelective_ERROR = new CodeMsg(205, "根据主键修改指定桌子的信息失败");
    public static final CodeMsg tableInsertSelective_SUCCESS = new CodeMsg(206, "新增桌子成功");
    public static final CodeMsg tableInsertSelective_ERROR = new CodeMsg(207, "新增桌子失败");
    public static final CodeMsg tableDeleteByPrimaryKey_SUCCESS = new CodeMsg(208, "根据主键删除桌子成功");
    public static final CodeMsg tableDeleteByPrimaryKey_ERROR = new CodeMsg(209, "根据主键删除桌子失败");

    //顾客管理模块
    public static final CodeMsg GuestSelect_SUCCESS = new CodeMsg(300, "按条件查询顾客成功");
    public static final CodeMsg GuestSelect_ERROR = new CodeMsg(301, "按条件查询顾客失败");
    public static final CodeMsg GuestSelectByPrimaryKey_SUCCESS = new CodeMsg(302, "根据id查询顾客成功");
    public static final CodeMsg GuestSelectByPrimaryKey_ERROR = new CodeMsg(303, "根据id查询顾客失败");
    public static final CodeMsg GuestUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(304, "根据主键修改指定顾客的信息成功");
    public static final CodeMsg GuestUpdateByPrimaryKeySelective_ERROR = new CodeMsg(305, "根据主键修改指定顾客的信息失败");
    public static final CodeMsg GuestInsertSelective_SUCCESS = new CodeMsg(306, "新增顾客成功");
    public static final CodeMsg GuestInsertSelective_ERROR = new CodeMsg(307, "新增顾客失败");
    public static final CodeMsg GuestDeleteByPrimaryKey_SUCCESS = new CodeMsg(308, "根据主键删除顾客成功");
    public static final CodeMsg GuestDeleteByPrimaryKey_ERROR = new CodeMsg(309, "根据主键删除顾客失败");

    //预定订单管理模块
    public static final CodeMsg OrderFormSelect_SUCCESS = new CodeMsg(500, "按条件查询预定订单成功");
    public static final CodeMsg OrderFormSelect_ERROR = new CodeMsg(501, "按条件查询预定订单失败");
    public static final CodeMsg OrderFormSelectByPrimaryKey_SUCCESS = new CodeMsg(502, "根据id查询预定订单成功");
    public static final CodeMsg OrderFormSelectByPrimaryKey_ERROR = new CodeMsg(503, "根据id查询预定订单失败");
    public static final CodeMsg OrderFormUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(504, "根据主键修改指定预定订单的信息成功");
    public static final CodeMsg OrderFormUpdateByPrimaryKeySelective_ERROR = new CodeMsg(505, "根据主键修改指定预定订单的信息失败");
    public static final CodeMsg OrderFormInsertSelective_SUCCESS = new CodeMsg(506, "新增预定订单成功");
    public static final CodeMsg OrderFormInsertSelective_ERROR = new CodeMsg(507, "新增预定订单失败");
    public static final CodeMsg OrderFormDeleteByPrimaryKey_SUCCESS = new CodeMsg(508, "根据主键删除预定订单成功");
    public static final CodeMsg OrderFormDeleteByPrimaryKey_ERROR = new CodeMsg(509, "根据主键删除预定订单失败");

    //预定中间表管理模块
    public static final CodeMsg OrderingSelect_SUCCESS = new CodeMsg(600, "按条件查询预定中间表表项成功");
    public static final CodeMsg OrderingSelect_ERROR = new CodeMsg(601, "按条件查询预定中间表表项失败");
    public static final CodeMsg OrderingSelectByPrimaryKey_SUCCESS = new CodeMsg(602, "根据id查询预定中间表表项成功");
    public static final CodeMsg OrderingSelectByPrimaryKey_ERROR = new CodeMsg(603, "根据id查询预定中间表表项失败");
    public static final CodeMsg OrderingUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(604, "根据主键修改指定预定中间表表项成功");
    public static final CodeMsg OrderingUpdateByPrimaryKeySelective_ERROR = new CodeMsg(605, "根据主键修改指定预定中间表表项失败");
    public static final CodeMsg OrderingInsertSelective_SUCCESS = new CodeMsg(606, "新增预定中间表表项成功");
    public static final CodeMsg OrderingInsertSelective_ERROR = new CodeMsg(607, "新增预定中间表表项失败");
    public static final CodeMsg OrderingDeleteByPrimaryKey_SUCCESS = new CodeMsg(608, "根据主键删除预定中间表表项成功");
    public static final CodeMsg OrderingDeleteByPrimaryKey_ERROR = new CodeMsg(609, "根据主键删除预定中间表表项失败");



    private CodeMsg(int code, String msg) {
            this.code=code;
            this.msg=msg;
        }
}