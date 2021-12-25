package com.outsideSong.outsideSong.service;

import com.outsideSong.outsideSong.domain.Note;
import com.outsideSong.outsideSong.domain.Score;
import com.outsideSong.outsideSong.dto.FixNote;
import com.outsideSong.outsideSong.dto.NoteDto;
import com.outsideSong.outsideSong.dto.ScoreDto;
import com.outsideSong.outsideSong.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;


    public ScoreDto getScoreList() {
        List<Score> findScoreList = scoreRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        for (Score score : findScoreList) {
            List<Note> noteList = score.getNoteList();
            for (Note note : noteList) {
                FixNote findFixNote = FixNote.getNote(note.getIndex());
                new NoteDto(
                        new String[]{findFixNote.getPitch(), findFixNote.getBeat()},
                        Long.valueOf(note.getIndex()),
                        findFixNote.getColor()
                );
            }
        }
        return null;
    }
}
