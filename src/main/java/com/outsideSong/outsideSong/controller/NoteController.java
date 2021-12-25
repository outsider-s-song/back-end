package com.outsideSong.outsideSong.controller;

import com.outsideSong.outsideSong.dto.NoteInsertRequestDto;
import com.outsideSong.outsideSong.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NoteController {

    private final NoteService noteService;

    // 노트 작성
    @PostMapping("/notes")
    public ResponseEntity<?> insertNote(@RequestBody NoteInsertRequestDto requestDto) {

        noteService.insertNote(requestDto);

        return new ResponseEntity<>(requestDto.getIndex(), HttpStatus.OK);
    }
}
