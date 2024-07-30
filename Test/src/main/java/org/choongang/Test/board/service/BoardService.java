package org.choongang.Test.board.service;


import lombok.RequiredArgsConstructor;
import org.choongang.Test.board.controllers.RequestBoard;
import org.choongang.Test.board.entities.BoardInformation;
import org.choongang.Test.board.repositories.BoardInformationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    public final BoardInformationRepository boardInformationRepository;

    //등록
    public void post(RequestBoard form) {
        BoardInformation boardInformation = new ModelMapper().map(form,BoardInformation.class);
        boardInformationRepository.saveAndFlush(boardInformation);
    }

    //목록
    public List<BoardInformation> list() {
        return boardInformationRepository.findAll(Sort.by(Sort.Direction.ASC, "seq"));
    }

    // 게시글 자세히 보기
    public BoardInformation detail(Long seq){
        return boardInformationRepository.findById(seq).orElse(null);
    }
    //수정
    public void update(RequestBoard form) {
        Long seq = form.getSeq();
        BoardInformation boardData = null;
        if (seq != null) {
            boardData = boardInformationRepository.findById(seq).orElse(null);
            if (boardData != null) {
                boardData.setTitle(form.getTitle());
                boardData.setContent(form.getContent());
                boardData.setWriter(form.getWriter());
            }
        }
        if (boardData == null) boardData = new ModelMapper().map(form, BoardInformation.class);
        boardInformationRepository.saveAndFlush(boardData);
    }
    // 삭제
    public void delete(Long seq){
        boardInformationRepository.deleteById(seq);
    }
}
