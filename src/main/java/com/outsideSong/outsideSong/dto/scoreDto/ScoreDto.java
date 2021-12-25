package com.outsideSong.outsideSong.dto.scoreDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScoreDto {
    private Long scoredId;
    private List<NoteDto> noteList;
}
