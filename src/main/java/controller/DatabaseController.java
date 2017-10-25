package controller;

import database.DbInit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/db")
public class DatabaseController {

  private DbInit db;

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
