package com.ahzeng.queuingSys.controller;


import com.ahzeng.queuingSys.services.impl.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    private WorkerServiceImpl workerServiceImpl;
//
//    @GetMapping("/user/{id}")
//    public Worker queryById(@PathVariable int id){
//        return workerService.queryById(id);
//    }

    @GetMapping("hello")
    public String hello(){
        return "Hello,Springboot";
    }
}
