package com.ahzeng.queuingSys.utils;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

public class QueuingTheoryUtil {
    /**输入：
        1. 服务台数量n（闲时：所有桌子的总和；忙时：对应桌型的总和）
        2. 顾客平均到达率lambda（闲时：每小时到达量；忙时：每小时到达量）
        3. 单个服务台平均服务率mu(这里固定为2)
        输出：
        1. 顾客平均等待时间Wq
        2. 顾客排队平均队长Lq
        3. 顾客在系统内逗留的时间均值Ws
     **/
    public static List<Double> predictQueuingTime(int n, double lambda, double mu){

        double P0 = 0;
        double Lq = 0;
        double Wq = 0;
        double Ws = 0;

        double rho = lambda/(n*mu);

        for (int k = 0; k < n-1; k++){
//            P0 = P0 + ((rho*n)^k)/factorial(k);
            P0 = P0 + pow(rho*n,k)/factorial(k);
        }
        //P0 = P0 + ((rho*n)^n)/(n*(1-rho)*factorial(n));
        P0 = P0 + pow(rho*n,n)/(n*(1-rho)*factorial(n));
        P0 = 1/P0;

        Lq = pow(rho*n,n)*rho*P0/(factorial(n)*pow(1-rho,2));
        Wq = Lq/ lambda;
        Ws = Wq + (1/mu);

        List<Double> result = new LinkedList<>();
        result.add(Lq);
        result.add(Wq);
        result.add(Ws);

        return result;
    }

    public static double factorial(double number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    public static double pow(double number, int power){
        double result = 1;
        for (int i = 0; i <power; i++){
            result = result*number;
        }
        return result;
    }
}
