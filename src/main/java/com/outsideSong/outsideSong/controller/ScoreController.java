package com.outsideSong.outsideSong.controller;

import com.outsideSong.outsideSong.dto.scoreDto.ScoreListDto;
import com.outsideSong.outsideSong.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/scores")
    public ResponseEntity<?> getScoreList(){
        ScoreListDto scoreList = scoreService.getScoreList();

        return new ResponseEntity<>( scoreList.getScoreList(), HttpStatus.OK);
    }

}
