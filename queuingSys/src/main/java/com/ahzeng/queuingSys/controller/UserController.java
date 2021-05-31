package com.ahzeng.queuingSys.controller;


import com.ahzeng.queuingSys.pojo.Guest;
import com.ahzeng.queuingSys.pojo.Worker;
import com.ahzeng.queuingSys.services.GuestService;
import com.ahzeng.queuingSys.services.WorkerService;
import com.ahzeng.queuingSys.utils.CodeMsg;
import com.ahzeng.queuingSys.utils.Result;
import com.ahzeng.queuingSys.vo.GuestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    WorkerService workerService;
    @Autowired
    GuestService guestService;
/**
 * 已经完成的业务方法：
 * 1. userLogin
 * 2. logOut（直接转login）
 * */
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
    @RequestMapping("/guestLogin")
    @ResponseBody
    public Result<GuestVo> guestLogin(@RequestBody Guest guest) {
        return guestService.GuestLoginVerify(guest);
    }


    @RequestMapping(value = "/logOut")
    public String logOut(){
        return "/login";
    }
}
