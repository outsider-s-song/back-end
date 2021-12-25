package com.outsideSong.outsideSong.service;

import com.outsideSong.outsideSong.dto.NoteInsertRequestDto;

import com.outsideSong.outsideSong.repository.NoteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.outsideSong.outsideSong.domain.Note;
import com.outsideSong.outsideSong.domain.Score;

import com.outsideSong.outsideSong.repository.ScoreRepository;


import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ScoreRepository scoreRepository;

    // 노트 작성
    public void insertNote(NoteInsertRequestDto requestDto) {

        String userNick = requestDto.getUserNick();
        String userPw = requestDto.getUserPw();
        String content = requestDto.getContents();
        int index = requestDto.getIndex();
        Long scoreId = requestDto.getScoreId();

        Optional<Note> foundNote = noteRepository.findByIndexAndScoreId(index, scoreId);
        if (foundNote.isPresent()) throw new IllegalStateException("이미 존재하는 노트입니다");

        Score score = scoreRepository.findById(scoreId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 악보입니다"));

        Note note = new Note(userNick, userPw, content, index, score);
        noteRepository.save(note);
    }

}
