package com.outsideSong.outsideSong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteUpdateRequestDto {
    private String userNick;
    private String userPw;
    private String contents;
}
