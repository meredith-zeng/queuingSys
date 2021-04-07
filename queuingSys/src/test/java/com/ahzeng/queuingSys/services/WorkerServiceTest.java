package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.Worker;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class WorkerServiceTest {
    @Autowired
    WorkerService workerService;

    @Test
    void loginVerify() {
        Worker worker = new Worker();
        worker.setId(1);
        worker.setPassword("123");
        System.out.println(workerService.loginVerify(worker));
    }

    @Test
    void userSelectByPrimaryKey() {
        int id = 3;
        System.out.println(workerService.userSelectByPrimaryKey(id));
    }

    @Test
    void userSelectAll() {
        System.out.println(workerService.userSelectAll().getData());
    }

    @Test
    void userUpdateByPrimaryKeySelective() {
        Worker record = new Worker();
        record.setAccount("root");
        record.setId(1);
        System.out.println(workerService.userUpdateByPrimaryKeySelective(record));
    }

    @Test
    void userInsertSelective() {
        Worker record = new Worker();
        record.setPassword("2333");
        record.setAccount("letItGo");
        System.out.println(workerService.userInsertSelective(record));
    }

    @Test
    void userDeleteByPrimaryKey() {
        Worker record = new Worker();
        record.setId(4);
        System.out.println(workerService.userDeleteByPrimaryKey(record));
    }
}