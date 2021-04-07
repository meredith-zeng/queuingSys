package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.WorkerMapper;
import com.ahzeng.queuingSys.pojo.Worker;
import com.ahzeng.queuingSys.services.WorkerService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.WorkerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;

    //登录验证
    @Override
    public CodeMsg loginVerify(Worker record){
        Worker worker =  workerMapper.selectByPrimaryKey(record.getId());
        if (worker != null) {
            if (worker.getPassword().equals(record.getPassword())) {
                return CodeMsg.Login_SUCCESS;
            }
        }
        return CodeMsg.Login_ERROR;
    }

    //根据id查询
    @Override
    public Result userSelectByPrimaryKey(int id){
        Worker worker =  workerMapper.selectByPrimaryKey(id);
        WorkerVo workerVo = new WorkerVo();
        if (worker != null){
            workerVo.setAccount(worker.getAccount());
            workerVo.setId(worker.getId());
            return Result.success(workerVo);
        }else {
            return Result.error(CodeMsg.WorkerSelectByPrimaryKey_ERROR);
        }
    }

    //查询存在的所有员工
    @Override
    public Result userSelectAll(){
        List<WorkerVo> workerVoList = new LinkedList<>();
        List<Worker> listOfWorker = workerMapper.selectAll();
        if (listOfWorker != null){
            for (Worker worker : listOfWorker) {
                WorkerVo workerVo = new WorkerVo();
                workerVo.setId(worker.getId());
                workerVo.setAccount(worker.getAccount());
                workerVoList.add(workerVo);
            }
            return Result.success(workerVoList);
        }
        return Result.error(CodeMsg.UserSelectAll_ERROR);
    }

    //修改指定员工的信息
    @Override
    @Transactional
    public CodeMsg userUpdateByPrimaryKeySelective(Worker record){
        int resultOfOperation = workerMapper.updateByPrimaryKeySelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.UserUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.UserUpdateByPrimaryKeySelective_ERROR;
    }

    //新增员工
    @Override
    @Transactional
    public CodeMsg userInsertSelective(Worker record){
        int resultOfOperation = workerMapper.insertSelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.UserInsertSelective_SUCCESS;
        }
        return CodeMsg.UserInsertSelective_ERROR;
    }

    //删除员工
    @Override
    @Transactional
    public CodeMsg userDeleteByPrimaryKey(Object key){
        int resultOfOperation = workerMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.UserDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.UserDeleteByPrimaryKey_ERROR;
    }

}
