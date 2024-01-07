package com.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


// 시작 페이지에 대한 요청이 들어왔을 때 이에 응답하는 컨트롤러
public class HomeContorller {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
