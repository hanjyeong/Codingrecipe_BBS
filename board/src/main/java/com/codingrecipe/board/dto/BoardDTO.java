package com.codingrecipe.board.dto;

import com.codingrecipe.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor      // 기본생성자
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자

public class BoardDTO {

    /*Dto 클래스란
    *  사용자가 입력한 값을 하나의 객체로 처리하기 위해서 필요한 내용들을 필드로 정의함*/

    private Long id;                            // 작성자 아이디
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private  int boardHits;                    // 글의 조회수
    private LocalDateTime boardCreatedTime;    // 글 작성 시간
    private LocalDateTime boardUpdatedTime;    // 글 수정 시간

    // entity -> dto 로 변환하는 메소드
    public static BoardDTO toSaveDTO( BoardEntity boardEntity){
        // dto 객체 선언
        BoardDTO boardDTO = new BoardDTO();

        // entity 객체의 필드값을 dto객체의 필드값으로 옮기기
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());

        return boardDTO;
    }

}
