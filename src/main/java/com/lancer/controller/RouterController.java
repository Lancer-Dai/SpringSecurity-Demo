package com.lancer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping({"","/index"})
    public String index(){
        return "index";
    }


    @RequestMapping("/myLogin")
    public String login(){
        return "login";
    }


    @RequestMapping("/level1")
    public String level1(){
        return "1";
    }

    @RequestMapping("/level2")
    public String level2(){
        return "2";
    }


    @RequestMapping("/level3")
    public String level3(){
        return "3";
    }

}
