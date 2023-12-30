package com.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// board/save, board/index 처럼 주소에서 /board 가 공통이므로
// 이 부분을 생략하고 주소를 요청하기 위해서 RequestMapping을 사용해서 공통된 부분을 묶어준다.
@RequestMapping("/board")
// 시작 페이지에 대한 요청이 들어왔을 때 이에 응답하는 컨트롤러
public class HomeContorller {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
