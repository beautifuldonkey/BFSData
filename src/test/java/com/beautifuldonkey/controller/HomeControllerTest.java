package com.beautifuldonkey.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

  @InjectMocks
  HomeController homeController;

  @Test
  public void showMain(){
    homeController.showMain();
  }
}
