package com.codingrecipe.board.controller;
import org.springframework.ui.Model;
import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// 시작화면에서 요청되는 것들에 대한 응답을 처리하는 부분
@Controller
@RequestMapping("/board")  /* board/save, board/index 처럼 주소에서 /board 가 공통이므로
 이 부분을 생략하고 주소를 요청하기 위해서 RequestMapping을 사용해서 공통된 부분을 묶어준다.*/
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
    @GetMapping("/") // 글목록에 대한 요청시 호출 메소드
    public String findAll(Model model){

        List<BoardDTO> boardDTOList = boardService.findAll();
        // db의 값을 html로 표현할 때(뷰로 전달) 모델 객체를 이용
        model.addAttribute("boardList",boardDTOList);

        return "list";
        }



}
