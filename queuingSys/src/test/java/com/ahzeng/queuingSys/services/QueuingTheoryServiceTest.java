package com.ahzeng.queuingSys.services;

import com.ahzeng.queuingSys.pojo.QueuingTheory;
import com.ahzeng.queuingSys.utils.QueuingTheoryUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
class QueuingTheoryServiceTest {
@Autowired
QueuingTheoryService queuingTheoryService;
@Autowired
TableOfHallService tableOfHallService;

    @Test
    void queuingTheorySelectByPrimaryKey() {
        System.out.println(queuingTheoryService.QueuingTheorySelectByPrimaryKey(8));

    }

    @Test
    void queuingTheoryUpdateByPrimaryKeySelective() {
//        String tableType = "小桌";
//        String tableType = "中桌";
//        String tableType = "大桌";
        String tableType = "全桌型";
        QueuingTheory queuingTheory = new QueuingTheory();
//        queuingTheory.setQueuingTheoryId(8);
//        queuingTheory.setQueuingTheoryId(9);
//        queuingTheory.setQueuingTheoryId(10);
        queuingTheory.setQueuingTheoryId(16);
        int n = tableOfHallService.countAllTableNumber().getData();
        double lambda = 8;
        double mu = 1;

        queuingTheory.setN(n);
        queuingTheory.setLambda(lambda);
        queuingTheory.setMu(mu);

        List<Double> queuingTheoryList = QueuingTheoryUtil.predictQueuingTime(n,lambda,mu);
        queuingTheory.setLq(queuingTheoryList.get(0));
        queuingTheory.setWq((queuingTheoryList.get(1))*60);
        queuingTheory.setWs((queuingTheoryList.get(2))*60);

        queuingTheoryService.QueuingTheoryUpdateByPrimaryKeySelective(queuingTheory);
    }

    @Test
    void queuingTheoryInsertSelective() {
//        String tableType = "小桌";
//        String tableType = "中桌";
//        String tableType = "大桌";
        String tableType = "全桌型";

        int n = tableOfHallService.countAllTableNumber().getData();
        double lambda = 13;
        double mu = 1;

        QueuingTheory queuingTheory = new QueuingTheory();
        queuingTheory.setN(n);
        queuingTheory.setLambda(lambda);
        queuingTheory.setMu(mu);
        queuingTheory.setTableType(tableType);

        List<Double> queuingTheoryList = QueuingTheoryUtil.predictQueuingTime(n,lambda,mu);
        queuingTheory.setLq(queuingTheoryList.get(0));
        queuingTheory.setWq((queuingTheoryList.get(1))*60);
        queuingTheory.setWs((queuingTheoryList.get(2))*60);

        queuingTheoryService.QueuingTheoryInsertSelective(queuingTheory);

    }
}