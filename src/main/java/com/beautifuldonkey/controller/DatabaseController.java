package com.beautifuldonkey.controller;

import com.beautifuldonkey.database.MySqlDatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/db")
public class DatabaseController {

  private MySqlDatabaseService db;

  @RequestMapping(value = "/checkStatus")
  public boolean checkDbStatus(){

    boolean status = false;

    try{
      status = db.isConnectionActive();
    } catch (Exception ex){
      System.out.println("Controller ex: "+ex.getMessage());
    }
    return status;
  }
}
