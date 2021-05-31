package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.GuestMapper;
import com.ahzeng.queuingSys.pojo.Guest;
import com.ahzeng.queuingSys.services.GuestService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.GuestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    GuestMapper guestMapper;

    //按条件查询顾客，不传参就是返回全部内容
    @Override
    public Result<List<GuestVo>> GuestSelect(Guest record) {
        List<Guest> guestList = guestMapper.select(record);
        if (guestList.size() > 0){
            List<GuestVo> guestVoList = new LinkedList<>();
            for (int i = 0; i < guestList.size(); i++){
                GuestVo guestVo = new GuestVo();
                guestVo.setGuestId(guestList.get(i).getGuestId());
                guestVo.setGender(guestList.get(i).getGender());
                guestVo.setPhoneNumber(guestList.get(i).getPhoneNumber());
                guestVo.setLastName(guestList.get(i).getLastName());
                guestVoList.add(i,guestVo);
            }
            return Result.success(guestVoList);
        }
        return Result.error(CodeMsg.GuestSelect_ERROR);
    }
    //根据id查询顾客
    @Override
    public Result<GuestVo> GuestSelectByPrimaryKey(int id) {
        Guest guest = guestMapper.selectByPrimaryKey(id);
        if (guest != null){
            GuestVo guestVo = new GuestVo();
            guestVo.setGuestId(guest.getGuestId());
            guestVo.setGender(guest.getGender());
            guestVo.setPhoneNumber(guest.getPhoneNumber());
            guestVo.setLastName(guest.getLastName());
            return Result.success(guestVo);
        }
        return Result.error(CodeMsg.GuestSelectByPrimaryKey_ERROR);
    }
    //根据主键修改指定顾客的信息
    @Transactional
    @Override
    public CodeMsg GuestUpdateByPrimaryKeySelective(Guest record) {
        if (guestMapper.updateByPrimaryKeySelective(record) == 1){
            return CodeMsg.GuestUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.GuestUpdateByPrimaryKeySelective_ERROR;
    }
    //新增顾客
    @Override
    @Transactional
    public CodeMsg GuestInsertSelective(Guest record) {
        if (guestMapper.insertSelective(record) == 1){
            return CodeMsg.GuestInsertSelective_SUCCESS;
        }
        return CodeMsg.GuestInsertSelective_ERROR;
    }
    //根据主键删除顾客
    @Override
    @Transactional
    public CodeMsg GuestDeleteByPrimaryKey(Object key) {
        int resultOfOperation = guestMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.GuestDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.GuestDeleteByPrimaryKey_ERROR;
    }

    @Override
    public Result<GuestVo> GuestLoginVerify(Guest record) {
        List<Guest> guestList = guestMapper.select(record);
        if (guestList.size() == 1){
            GuestVo guestVo = new GuestVo();
            guestVo.setGuestId(guestList.get(0).getGuestId());
            guestVo.setPhoneNumber(guestList.get(0).getPhoneNumber());
            return Result.success(guestVo);
        }
        return Result.error(CodeMsg.GuestLoginVerify_ERROR);
    }
}
