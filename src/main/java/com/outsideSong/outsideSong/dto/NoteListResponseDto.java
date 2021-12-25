package com.outsideSong.outsideSong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoteListResponseDto {

    private Long scoreId;
    private Long noteId;
    private String userNick;
    private String content;
    private String[] note;
    private int index;
    private String color;
    private boolean status;
}
