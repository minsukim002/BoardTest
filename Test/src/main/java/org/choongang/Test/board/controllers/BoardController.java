package org.choongang.Test.board.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.Test.board.entities.BoardInformation;
import org.choongang.Test.board.repositories.BoardInformationRepository;
import org.choongang.Test.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardInformationRepository boardInformationRepository;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("BoardInformation", boardService.list());
        return "board/list";
    }

    @GetMapping("/post")
    public String post(@ModelAttribute RequestBoard form){
        return "board/post";
    }

    @PostMapping("/post")
    public String postPs(@Valid RequestBoard form, Errors errors){
        // 1. 등록을 위한 entities 만들기
        // 2. boardService 필요 게시판 등록
        // 3. 맞는 repositories 만들기
        // 4. 정보를 받을 수 있는 html 작성.
        if(errors.hasErrors()){
            return "board/post";
        }
        boardService.post(form);
        return "redirect:/board/list";
    }

    @GetMapping("/detail/{seq}")
    public String detail(@PathVariable("seq") Long seq, Model model){
        model.addAttribute("BoardInformation", boardService.detail(seq));

        return "board/detail";
    }

    @GetMapping("/update/{seq}")
    public String updateGet(@ModelAttribute RequestBoard board,@PathVariable("seq") Long seq, Model model) {
        BoardInformation update = boardInformationRepository.findById(seq).orElse(null);
        board.setSeq(update.getSeq());
        board.setTitle(update.getTitle());
        board.setContent(update.getContent());
        board.setWriter(update.getWriter());

        return "board/update";
    }

    @PostMapping("/update")
    public String updatePost(@Valid RequestBoard form, Errors errors) {
        if(errors.hasErrors()){
            return "board/update";
        }
        boardService.update(form);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{seq}")
    public String delete(@PathVariable("seq") Long seq){
        boardService.delete(seq);
        return "redirect:/board/list";
    }
}
