package com.outsideSong.outsideSong.dto.scoreDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NoteDto {
    private String[] note;
    private Long index;
    private String color;
}
