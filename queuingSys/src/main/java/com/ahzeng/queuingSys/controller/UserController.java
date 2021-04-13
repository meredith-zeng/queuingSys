package com.ahzeng.queuingSys.controller;


import com.ahzeng.queuingSys.pojo.Worker;
import com.ahzeng.queuingSys.services.WorkerService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    WorkerService workerService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public CodeMsg userLogin(@RequestBody Worker worker) {
        if (workerService.loginVerify(worker).equals(CodeMsg.Login_SUCCESS)){
            return CodeMsg.Login_SUCCESS;
        }
        return CodeMsg.Login_ERROR;
    }
    @RequestMapping(value = "/logOut")
    public String logOut(){
        return "/index";
    }
}
