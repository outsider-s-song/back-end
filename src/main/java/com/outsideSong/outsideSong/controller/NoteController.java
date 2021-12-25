package com.outsideSong.outsideSong.controller;

import com.outsideSong.outsideSong.dto.NoteDeleteRequestDto;
import com.outsideSong.outsideSong.dto.NoteUpdateRequestDto;
import com.outsideSong.outsideSong.service.NoteService;
import lombok.RequiredArgsConstructor;
import com.outsideSong.outsideSong.dto.NoteInsertRequestDto;
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


    @PostMapping("/notes/delete")
    public ResponseEntity<?> deleteNote(@RequestParam Long noteId, @RequestBody NoteDeleteRequestDto requestDto){
        noteService.deleteNote(noteId, requestDto);
        return new ResponseEntity<>("delete note complete", HttpStatus.OK);
    }

    @PutMapping("/notes")
    public ResponseEntity<?> updateNote(@RequestBody NoteUpdateRequestDto requestDto, @RequestParam Long noteId){
        noteService.updateNote(noteId, requestDto);
        return new ResponseEntity<>("note update complete", HttpStatus.OK);
    }

}
