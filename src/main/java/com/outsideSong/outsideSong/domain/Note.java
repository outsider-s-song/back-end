package com.outsideSong.outsideSong.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Note {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;

    private String userNick;

    private String userPw;

    private String content;

    private int index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "score_id")
    private Score score;

    public Note(String userNick, String userPw, String content, int index, Score score) {
        this.userNick = userNick;
        this.userPw = userPw;
        this.content = content;
        this.index = index;
        this.score = score;
    }
}
