package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// Service 클래스 : dto -> entity(entity 클래스) , entity ->dto(dto 클래스) 로 변환하는 클래스
public class BoardService {

    // 생성자 주입
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        // service -> repository 클래스로 전달

        /* repository 클래스는 객체만 다루는 클래스
           따라서 값을 전달해주기 위해서는 dto -> entity로 변환 해주어야함
         */
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);

    }




}
