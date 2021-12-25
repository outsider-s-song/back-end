package com.outsideSong.outsideSong.controller;

import com.outsideSong.outsideSong.service.NoteService;
import lombok.RequiredArgsConstructor;
import com.outsideSong.outsideSong.dto.NoteInsertRequestDto;
import com.outsideSong.outsideSong.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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


    @DeleteMapping("/notes")
    public ResponseEntity<?> deleteNote(@RequestParam Long noteId, ){
        noteService.deleteNote(noteId);
        return new ResponseEntity<>("delete note complete", HttpStatus.OK);
    }

}
