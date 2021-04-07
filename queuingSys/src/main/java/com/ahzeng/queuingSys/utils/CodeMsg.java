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


    private CodeMsg(int code, String msg) {
            this.code=code;
            this.msg=msg;
        }
}