package org.choongang.Test.board.controllers;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestBoard {
    Long seq;
    @NotBlank
    private String writer;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
