package com.domain.data_processing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ProcessingController {

    @GetMapping("getmsg")
    public String get(){
        return "Hello This is Anand Vihari !!!!";
    }
}
