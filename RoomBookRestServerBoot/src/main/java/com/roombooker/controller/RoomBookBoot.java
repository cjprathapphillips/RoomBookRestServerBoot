package com.roombooker.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Prathap Phillips
 *
 */
@SpringBootApplication
@ComponentScan("com.roombooker")
@EntityScan("com.roombooker.model")

/** Room Booking Management System Start Up */
public class RoomBookBoot{
   public static void main(String[] args) {
      SpringApplication.run(RoomBookBoot.class, args);
   }
}