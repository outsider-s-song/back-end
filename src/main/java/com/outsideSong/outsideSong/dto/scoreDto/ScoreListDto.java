package com.outsideSong.outsideSong.dto.scoreDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreListDto {
    private List<ScoreDto> scoreList;
}
