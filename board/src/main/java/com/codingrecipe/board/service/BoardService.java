package com.codingrecipe.board.service;

import com.codingrecipe.board.dto.BoardDTO;
import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    public List<BoardDTO> findAll() {

        //repository에서 가져온 값들(entity) 리스트로 저장하기
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        // 변환한 값을 담을 dto list 선언
        List<BoardDTO> boardDTOList = new ArrayList<>();

        // BoardEntity -> BoardDTO 값으로 변환 ( 각각의 entity값들을 가져와서 변환 필요 : for-each )
        for(BoardEntity boardEntity : boardEntityList){

            // dto로 변환된 값을 add 메소드를 이용하여 List에 바로 추가하기
            boardDTOList.add(BoardDTO.toSaveDTO(boardEntity)) ;
        }

        return boardDTOList;

    }
}
