package com.ahzeng.queuingSys.services.impl;

import com.ahzeng.queuingSys.mapper.WorkerMapper;
import com.ahzeng.queuingSys.pojo.Worker;
import com.ahzeng.queuingSys.services.WorkerService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.User;
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
    public Result userSelectByPrimaryKey(int id){
        Worker worker =  workerMapper.selectByPrimaryKey(id);
        User user = new User();
        if (worker != null){
            user.setAccount(worker.getAccount());
            user.setId(worker.getId());
            return Result.success(user);
        }else {
            return Result.error(CodeMsg.WorkerSelectByPrimaryKey_ERROR);
        }
    }

    //查询存在的所有员工
    public Result userSelectAll(){
        List<User> userList = new LinkedList<>();
        List<Worker> listOfWorker = workerMapper.selectAll();
        if (listOfWorker != null){
            for (Worker worker : listOfWorker) {
                User user = new User();
                user.setId(worker.getId());
                user.setAccount(worker.getAccount());
                userList.add(user);
            }
            return Result.success(userList);
        }
        return Result.error(CodeMsg.UserSelectAll_ERROR);
    }

    //修改指定员工的信息
    @Transactional
    public CodeMsg userUpdateByPrimaryKeySelective(Worker record){
        int resultOfOperation = workerMapper.updateByPrimaryKeySelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.UserUpdateByPrimaryKeySelective_SUCCESS;
        }
        return CodeMsg.UserUpdateByPrimaryKeySelective_ERROR;
    }

    //新增员工
    @Transactional
    public CodeMsg userInsertSelective(Worker record){
        int resultOfOperation = workerMapper.insertSelective(record);
        if (resultOfOperation == 1){
            return CodeMsg.UserInsertSelective_SUCCESS;
        }
        return CodeMsg.UserInsertSelective_ERROR;
    }

    //删除员工
    @Transactional
    public CodeMsg userDeleteByPrimaryKey(Object key){
        int resultOfOperation = workerMapper.deleteByPrimaryKey(key);
        if (resultOfOperation == 1){
            return CodeMsg.UserDeleteByPrimaryKey_SUCCESS;
        }
        return CodeMsg.UserDeleteByPrimaryKey_ERROR;
    }

}
