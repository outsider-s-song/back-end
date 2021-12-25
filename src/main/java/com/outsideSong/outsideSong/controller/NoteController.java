package com.outsideSong.outsideSong.controller;

import com.outsideSong.outsideSong.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

}
