package com.beautifuldonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

  @RequestMapping("/")
  public String showMain(){ return "main"; }

  @RequestMapping("/checkStatus")
  public boolean checkStatus(){ return true; }

}
