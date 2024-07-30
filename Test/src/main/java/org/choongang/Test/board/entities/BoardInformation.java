package org.choongang.Test.board.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.Test.global.entities.BaseEntity;

@Data
@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardInformation extends BaseEntity {


    @Id @GeneratedValue
    private Long seq;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;
}
