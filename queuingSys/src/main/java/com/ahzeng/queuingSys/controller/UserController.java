package com.ahzeng.queuingSys.controller;


import com.ahzeng.queuingSys.pojo.Worker;
import com.ahzeng.queuingSys.services.WorkerService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    WorkerService workerService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody Worker worker) {
        if (workerService.loginVerify(worker).equals(CodeMsg.Login_SUCCESS)){
            return "index";
        }
        return "login";
    }

}
