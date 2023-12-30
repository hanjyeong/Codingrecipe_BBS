package com.codingrecipe.board.controller;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 시작화면에서 요청되는 것들에 대한 응답을 처리하는 부분
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor // 초기화 되지 않은 final 값을 초기화
public class BoardController {

    // 생성자 주입
    private final BoardService boardService;
    @GetMapping("/save")
        public String saveForm(){
            return "save";
        }


    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) { //html로 입력한 값을 서버로 가져오는 메소드
        // 값 어떻게 들어왔는지 확인해보기
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
        }

}
