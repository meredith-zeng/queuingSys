package com.ahzeng.queuingSys.services.impl;


import com.ahzeng.queuingSys.mapper.QueuingFormMapper;
import com.ahzeng.queuingSys.pojo.Applying;
import com.ahzeng.queuingSys.pojo.Guest;
import com.ahzeng.queuingSys.pojo.QueuingForm;
import com.ahzeng.queuingSys.services.ApplyingService;
import com.ahzeng.queuingSys.services.GuestService;
import com.ahzeng.queuingSys.services.QueuingFormService;
import com.ahzeng.queuingSys.services.QueuingTheoryService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.DateUtil;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.GuestVo;
import com.ahzeng.queuingSys.vo.QueuingFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class QueuingFormServiceImpl implements QueuingFormService {
    @Autowired
    QueuingFormMapper queuingFormMapper;
    @Autowired
    GuestService guestService;
    @Autowired
    ApplyingService applyingService;
    @Autowired
    QueuingTheoryService queuingTheoryService;

    @Override
    public Result<List<QueuingFormVo>> QueuingFormSelect(QueuingForm record) {
        List<QueuingForm> queuingFormList= queuingFormMapper.select(record);
        if(queuingFormList.size() > 0){
            List<QueuingFormVo> queuingFormVoList = new LinkedList<>();
            for (int i = 0; i < queuingFormList.size(); i++){
                QueuingFormVo queuingFormVo = new QueuingFormVo();

                queuingFormVo.setGuestId(queuingFormList.get(i).getGuestId());

                    GuestVo guestVo = guestService.GuestSelectByPrimaryKey(queuingFormVo.getGuestId()).getData();
                    if(guestVo != null) {

                        queuingFormVo.setGender(guestVo.getGender());
                        queuingFormVo.setLastName(guestVo.getLastName());
                        queuingFormVo.setPhoneNumber(guestVo.getPhoneNumber());

                        queuingFormVo.setQueuingOrderId(queuingFormList.get(i).getQueuingOrderId());
                        queuingFormVo.setQueuingStatus(queuingFormList.get(i).getQueuingStatus());
                        queuingFormVo.setQueuingBeginTime(queuingFormList.get(i).getQueuingBeginTime());
                        queuingFormVo.setPredictQueuingTime(queuingFormList.get(i).getPredictQueuingTime());
                        queuingFormVo.setGuestNumber(queuingFormList.get(i).getGuestNumber());
                        queuingFormVo.setActualArriveTime(queuingFormList.get(i).getActualArriveTime());

                    }


                queuingFormVoList.add(i,queuingFormVo);
            }
            return Result.success(queuingFormVoList);
        }
        return Result.error(CodeMsg.QueuingFormSelect_ERROR);
    }

    @Override
    public Result<List<QueuingFormVo>> QueuingFormSelectAll() {
        List<QueuingForm> queuingFormList= queuingFormMapper.selectAll();
        if(queuingFormList.size() > 0){
            List<QueuingFormVo> queuingFormVoList = new LinkedList<>();
            for (int i = 0; i < queuingFormList.size(); i++){
                QueuingFormVo queuingFormVo = new QueuingFormVo();

                queuingFormVo.setGuestId(queuingFormList.get(i).getGuestId());

                GuestVo guestVo = guestService.GuestSelectByPrimaryKey(queuingFormVo.getGuestId()).getData();
                if(guestVo != null) {

                    queuingFormVo.setGender(guestVo.getGender());
                    queuingFormVo.setLastName(guestVo.getLastName());
                    queuingFormVo.setPhoneNumber(guestVo.getPhoneNumber());

                    queuingFormVo.setQueuingOrderId(queuingFormList.get(i).getQueuingOrderId());
                    queuingFormVo.setQueuingStatus(queuingFormList.get(i).getQueuingStatus());
                    queuingFormVo.setQueuingBeginTime(queuingFormList.get(i).getQueuingBeginTime());
                    queuingFormVo.setPredictQueuingTime(queuingFormList.get(i).getPredictQueuingTime());
                    queuingFormVo.setGuestNumber(queuingFormList.get(i).getGuestNumber());
                    queuingFormVo.setActualArriveTime(queuingFormList.get(i).getActualArriveTime());

                }


                queuingFormVoList.add(i,queuingFormVo);
            }
            return Result.success(queuingFormVoList);
        }
        return Result.error(CodeMsg.QueuingFormSelectAll_ERROR);
    }


    @Override
    public Result<QueuingFormVo> QueuingFormSelectByPrimaryKey(int id) {
        QueuingForm queuingForm = queuingFormMapper.selectByPrimaryKey(id);


        queuingForm.setGuestId(queuingForm.getGuestId());

        GuestVo guestVo = guestService.GuestSelectByPrimaryKey(queuingForm.getGuestId()).getData();

        if(guestVo != null) {
            QueuingFormVo queuingFormVo = new QueuingFormVo();

            queuingFormVo.setGender(guestVo.getGender());
            queuingFormVo.setLastName(guestVo.getLastName());
            queuingFormVo.setPhoneNumber(guestVo.getPhoneNumber());

            queuingFormVo.setQueuingOrderId(queuingForm.getQueuingOrderId());
            queuingFormVo.setQueuingStatus(queuingForm.getQueuingStatus());
            queuingFormVo.setQueuingBeginTime(queuingForm.getQueuingBeginTime());
            queuingFormVo.setPredictQueuingTime(queuingForm.getPredictQueuingTime());
            queuingFormVo.setGuestNumber(queuingForm.getGuestNumber());
            queuingFormVo.setActualArriveTime(queuingForm.getActualArriveTime());

            return Result.success(queuingFormVo);
        }
        return Result.error(CodeMsg.QueuingFormSelectByPrimaryKey_SUCCESS);
    }

    /** 1. 预计到号时间只会在订单生成时调用算法进行计算: 还是需要调用自己封装的代码
     * * 2. 更新实际到号时间：数据库里设置了根据当前时间戳进行修改
     * *  所以只需要在叫号的时候调用该方法对排号状态进行修改即可
     **/
    @Override
    public CodeMsg QueuingFormUpdateByPrimaryKeySelective(QueuingForm record) {
        int resultOfOperation = queuingFormMapper.updateByPrimaryKeySelective(record);
        if(resultOfOperation == 1) {

            Applying applying = new Applying();
            applying.setQueuingOrderId(record.getQueuingOrderId());
            applying.setGuestId(record.getGuestId());

            if (applyingService.ApplyingUpdateByPrimaryKey(applying) == CodeMsg.ApplyingUpdateByPrimaryKey_SUCCESS){
                return CodeMsg.QueuingFormUpdateByPrimaryKeySelective_SUCCESS;
            }
        }
        return CodeMsg.QueuingFormUpdateByPrimaryKeySelective_ERROR;
    }

    /**
     * QueuingForm需要设置的字段：
     * 1. guestId
     * 2. queuingStatus（"直接设置"）
     * 3. predictQueuingTime（”算法计算“）
     * 4. guestNumber（”前端获取“）
     * 5. phoneNumber（）
     */

    @Override
    public CodeMsg QueuingFormInsertSelective(QueuingForm record) {
        int resultOfOperation = queuingFormMapper.insertSelective(record);
        if (resultOfOperation ==1){
            Applying applying = new Applying();

            applying.setQueuingOrderId(record.getQueuingOrderId());
            applying.setGuestId(record.getGuestId());

            if (applyingService.ApplyingInsertSelective(applying) == CodeMsg.ApplyingInsertSelective_SUCCESS){
                return CodeMsg.QueuingFormInsertSelective_SUCCESS;
            }
        }

        return CodeMsg.QueuingFormInsertSelective_ERROR;
    }


    @Override
    public CodeMsg QueuingFormDeleteByPrimaryKey(QueuingForm record) {
        int resultOfOperation = queuingFormMapper.deleteByPrimaryKey(record);
        if (resultOfOperation ==1){
            Applying applying = new Applying();
            applying.setQueuingOrderId(record.getQueuingOrderId());
            if(applyingService.ApplyingDeleteByPrimaryKey(applying) == CodeMsg.ApplyingDeleteByPrimaryKey_SUCCESS){
                return CodeMsg.QueuingFormDeleteByPrimaryKey_SUCCESS;
            }
        }
        return CodeMsg.QueuingFormDeleteByPrimaryKey_ERROR;
    }

    @Override
    public Result<Integer> countQueuingGuestNumber() {
        if (queuingFormMapper.countQueuingGuestNumber() >= 0){
            return Result.success(queuingFormMapper.countQueuingGuestNumber());

        }
        return Result.error(CodeMsg.countQueuingGuestNumber_ERROR);
    }

    @Override
    public Result<QueuingFormVo> QueuingFormNewOne(QueuingFormVo record) throws ParseException {
        Guest guest = new Guest();
        guest.setPhoneNumber(record.getPhoneNumber());

        if (guestService.GuestSelect(guest).getData() != null){
            int guestId = guestService.GuestSelect(guest).getData().get(0).getGuestId();

            QueuingForm queuingForm = new QueuingForm();
            queuingForm.setGuestId(guestId);
            queuingForm.setQueuingStatus("排号中");
            queuingForm.setGuestNumber(record.getGuestNumber());
            queuingForm.setPhoneNumber(record.getPhoneNumber());

            if(QueuingFormInsertSelective(queuingForm) ==CodeMsg.QueuingFormInsertSelective_SUCCESS){
                QueuingForm result =  queuingFormMapper.select(queuingForm).get(0);
                if(result != null){
                    Date time = result.getQueuingBeginTime();
                    List<Date> dateList  = DateUtil.switchBusyCalendar(time);
                    boolean lunchResult = DateUtil.belongCalendar(time,dateList.get(0),dateList.get(1));
                    boolean dinnerResult = DateUtil.belongCalendar(time,dateList.get(2),dateList.get(3));
                    if(lunchResult || dinnerResult){
                        //忙时确认桌型大小
                        int guestNumber = result.getGuestNumber();
                        if (guestNumber <4 && guestNumber >0){
                            //小桌
                            double Wq =  queuingTheoryService.QueuingTheorySelectByPrimaryKey(9).getData().getWq();
                            int minute =  (int) Wq%60;
                            int hour = (int) Wq/60;
                            Date predictTime = DateUtil.addTime(time,hour,minute,0);
                            result.setPredictQueuingTime(predictTime);
                        }else if(guestNumber>4 && guestNumber <7){
                            //中桌
                            double Wq = queuingTheoryService.QueuingTheorySelectByPrimaryKey(10).getData().getWq();
                            int minute =  (int) Wq%60;
                            int hour = (int) Wq/60;
                            Date predictTime = DateUtil.addTime(time,hour,minute,0);
                            result.setPredictQueuingTime(predictTime);
                        }else if (guestNumber>7){
                            //大桌
                            double Wq = queuingTheoryService.QueuingTheorySelectByPrimaryKey(8).getData().getWq();
                            int minute =  (int) Wq%60;
                            int hour = (int) Wq/60;
                            Date predictTime = DateUtil.addTime(time,hour,minute,0);
                            result.setPredictQueuingTime(predictTime);
                        }
                    }
                    else{
                        //闲时进行大小中桌的合并测试
                        double Wq = queuingTheoryService.QueuingTheorySelectByPrimaryKey(16).getData().getWq();
                        int minute =  (int) Wq%60;
                        int hour = (int) Wq/60;
                        Date predictTime = DateUtil.addTime(time,hour,minute,0);
                        result.setPredictQueuingTime(predictTime);
                    }
                    int resultOfOperation = queuingFormMapper.updateByPrimaryKeySelective(result);
                    if(resultOfOperation ==1){
                        QueuingFormVo queuingFormVo = new QueuingFormVo();

                        queuingFormVo.setPredictQueuingTime(queuingForm.getPredictQueuingTime());
                        queuingFormVo.setGuestId(guestId);
                        queuingFormVo.setQueuingStatus("排号中");
                        queuingFormVo.setPredictQueuingTime(result.getPredictQueuingTime());
                        queuingFormVo.setGuestNumber(queuingForm.getGuestNumber());
                        queuingFormVo.setQueuingBeginTime(queuingForm.getQueuingBeginTime());
                        queuingFormVo.setQueuingOrderId(queuingForm.getQueuingOrderId());
                        queuingFormVo.setPhoneNumber(queuingForm.getPhoneNumber());
                        return Result.success(queuingFormVo);

                    }
                }


            }
        }
            return Result.error(CodeMsg.QueuingFormInsertSelective_ERROR);
    }
}
