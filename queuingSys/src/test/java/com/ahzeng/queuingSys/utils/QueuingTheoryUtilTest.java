package com.ahzeng.queuingSys.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class QueuingTheoryUtilTest {

    @Test
    void predictQueuingTime() {
        int n = 2;
        double lambda =3;
        double mu = 2;

        List<Double> result = QueuingTheoryUtil.predictQueuingTime(n,lambda,mu);

//        double a  =result.get(1)*60;
//        int  predictTime =  (int) a;

        System.out.println("Ws" + result.get(2));
        System.out.println("Wq" + result.get(1));
        System.out.println("Lq" + result.get(0));
    }
}