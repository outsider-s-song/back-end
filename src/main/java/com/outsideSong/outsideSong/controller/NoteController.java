package com.outsideSong.outsideSong.controller;

import com.outsideSong.outsideSong.dto.ScoreDto;
import com.outsideSong.outsideSong.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

}
