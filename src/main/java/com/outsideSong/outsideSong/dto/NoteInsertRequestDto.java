package com.outsideSong.outsideSong.dto;

import lombok.Getter;

@Getter
public class NoteInsertRequestDto {

    private String userNick;
    private String userPw;
    private String contents;
    private int index;
    private Long scoreId;
}
