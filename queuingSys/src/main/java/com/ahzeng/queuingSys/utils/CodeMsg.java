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
    public static final CodeMsg countTableNumber_SUCCESS = new CodeMsg(210, "根据类型统计桌子数量成功");
    public static final CodeMsg countTableNumber_ERROR = new CodeMsg(211, "根据类型统计桌子数量失败");
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
    public static final CodeMsg GuestLoginVerify_SUCCESS = new CodeMsg(310, "顾客登录成功");
    public static final CodeMsg GuestLoginVerify_ERROR = new CodeMsg(311, "顾客登录失败");

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

    //排队订单管理模块
    public static final CodeMsg QueuingFormSelect_SUCCESS = new CodeMsg(700, "按条件查询排队订单成功");
    public static final CodeMsg QueuingFormSelect_ERROR = new CodeMsg(701, "按条件查询排队订单失败");
    public static final CodeMsg QueuingFormSelectAll_SUCCESS = new CodeMsg(702, "查询所有排队订单成功");
    public static final CodeMsg QueuingFormSelectAll_ERROR = new CodeMsg(703, "查询所有排队订单失败");
    public static final CodeMsg QueuingFormSelectByPrimaryKey_SUCCESS = new CodeMsg(704, "根据id查询排队订单成功");
    public static final CodeMsg QueuingFormSelectByPrimaryKey_ERROR = new CodeMsg(705, "根据id查询排队订单失败");
    public static final CodeMsg QueuingFormUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(706, "根据主键修改指定排队订单成功");
    public static final CodeMsg QueuingFormUpdateByPrimaryKeySelective_ERROR = new CodeMsg(707, "根据主键修改指定排队订单失败");
    public static final CodeMsg QueuingFormInsertSelective_SUCCESS = new CodeMsg(708, "新增排队订单成功");
    public static final CodeMsg QueuingFormInsertSelective_ERROR = new CodeMsg(709, "新增排队订单失败");
    public static final CodeMsg QueuingFormDeleteByPrimaryKey_SUCCESS = new CodeMsg(710, "根据主键删除排队订单成功");
    public static final CodeMsg QueuingFormDeleteByPrimaryKey_ERROR = new CodeMsg(711, "根据主键删除排队订单失败");
    public static final CodeMsg countQueuingGuestNumber_SUCCESS = new CodeMsg(712, "查询正在排队的顾客数量成功");
    public static final CodeMsg countQueuingGuestNumber_ERROR = new CodeMsg(713, "查询正在排队的顾客数量失败");
    //排队中间表管理
    public static final CodeMsg ApplyingSelect_SUCCESS = new CodeMsg(714, "按条件查询排队中间表成功");
    public static final CodeMsg ApplyingSelect_ERROR = new CodeMsg(715, "按条件查询排队中间表失败");
    public static final CodeMsg ApplyingSelectAll_SUCCESS = new CodeMsg(716, "查询所有排队中间表成功");
    public static final CodeMsg ApplyingSelectAll_ERROR = new CodeMsg(717, "查询所有排队中间表失败");
    public static final CodeMsg ApplyingSelectByPrimaryKey_SUCCESS = new CodeMsg(718, "根据id查询排队中间表成功");
    public static final CodeMsg ApplyingSelectByPrimaryKey_ERROR = new CodeMsg(719, "根据id查询排队中间表失败");
    public static final CodeMsg ApplyingUpdateByPrimaryKey_SUCCESS = new CodeMsg(720, "根据主键修改指定排队中间表成功");
    public static final CodeMsg ApplyingUpdateByPrimaryKey_ERROR = new CodeMsg(721, "根据主键修改指定排队中间表失败");
    public static final CodeMsg ApplyingInsertSelective_SUCCESS = new CodeMsg(722, "新增排队中间表成功");
    public static final CodeMsg ApplyingInsertSelective_ERROR = new CodeMsg(723, "新增排队中间表失败");
    public static final CodeMsg ApplyingDeleteByPrimaryKey_SUCCESS = new CodeMsg(724, "根据主键删除排队中间表成功");
    public static final CodeMsg ApplyingDeleteByPrimaryKey_ERROR = new CodeMsg(725, "根据主键删除排队中间表失败");


    //排队数据表管理
    public static final CodeMsg QueuingExcelSelect_SUCCESS = new CodeMsg(800, "按条件查询排队论数据成功");
    public static final CodeMsg QueuingExcelSelect_ERROR = new CodeMsg(801, "按条件查询排队论数据失败");
    public static final CodeMsg QueuingExcelSelectByPrimaryKey_SUCCESS = new CodeMsg(802, "根据id查询排队论数据成功");
    public static final CodeMsg QueuingExcelSelectByPrimaryKey_ERROR = new CodeMsg(803, "根据id查询排队论数据失败");
    public static final CodeMsg QueuingExcelUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(804, "根据主键修改指定日期的排队论数据成功");
    public static final CodeMsg QueuingExcelUpdateByPrimaryKeySelective_ERROR = new CodeMsg(805, "根据主键修改指定日期的排队论数据失败");
    public static final CodeMsg QueuingExcelInsertSelective_SUCCESS = new CodeMsg(806, "新增排队论数据成功");
    public static final CodeMsg QueuingExcelInsertSelective_ERROR = new CodeMsg(807, "新增排队论数据失败");
    public static final CodeMsg QueuingExcelDeleteByPrimaryKey_SUCCESS = new CodeMsg(808, "根据主键删除排队论数据成功");
    public static final CodeMsg QueuingExcelDeleteByPrimaryKey_ERROR = new CodeMsg(809, "根据主键删除排队论数据失败");
    public static final CodeMsg QueuingExcelSelectAll_SUCCESS = new CodeMsg(810, "查询所有排队论数据成功");
    public static final CodeMsg QueuingExcelSelectAll_ERROR = new CodeMsg(811, "查询所有排队论数据失败");
    //排队论表管理
    public static final CodeMsg QueuingTheorySelectByPrimaryKey_SUCCESS = new CodeMsg(812, "根据id查询指定的排队数据成功");
    public static final CodeMsg QueuingTheorySelectByPrimaryKey_ERROR = new CodeMsg(813, "根据id查询指定的排队数据失败");
    public static final CodeMsg QueuingTheoryUpdateByPrimaryKeySelective_SUCCESS = new CodeMsg(814, "根据主键修改指定的排队数据成功");
    public static final CodeMsg QueuingTheoryUpdateByPrimaryKeySelective_ERROR = new CodeMsg(815, "根据主键修改指定的排队数据失败");
    public static final CodeMsg QueuingTheoryInsertSelective_SUCCESS = new CodeMsg(816, "新增排队数据成功失败");
    public static final CodeMsg QueuingTheoryInsertSelective_ERROR = new CodeMsg(817, "新增排队数据失败");

    private CodeMsg(int code, String msg) {
            this.code=code;
            this.msg=msg;
        }
}