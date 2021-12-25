package com.outsideSong.outsideSong.service;

import com.outsideSong.outsideSong.domain.Note;
import com.outsideSong.outsideSong.domain.Score;
import com.outsideSong.outsideSong.dto.FixNote;
import com.outsideSong.outsideSong.dto.scoreDto.NoteComparator;
import com.outsideSong.outsideSong.dto.scoreDto.NoteDto;
import com.outsideSong.outsideSong.dto.scoreDto.ScoreDto;
import com.outsideSong.outsideSong.dto.scoreDto.ScoreListDto;
import com.outsideSong.outsideSong.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;


    public ScoreListDto getScoreList() {
        List<ScoreDto> scoreDtoList = new ArrayList<>();

        List<Score> findScoreList = scoreRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        for (Score score : findScoreList) {
            List<Note> noteList = score.getNoteList();
            List<NoteDto> noteDtoList = new ArrayList<>();
            NoteComparator comp = new NoteComparator();
            Collections.sort(noteDtoList, comp);

            for (Note note : noteList) {
                FixNote findFixNote = FixNote.getNote(note.getIndex());
                NoteDto newNoteDto = new NoteDto(
                        new String[]{findFixNote.getPitch(), findFixNote.getBeat()},
                        Long.valueOf(note.getIndex()),
                        findFixNote.getColor()
                );
                noteDtoList.add(newNoteDto);
            }

            ScoreDto scoreDto = new ScoreDto(score.getId(), noteDtoList );
            scoreDtoList.add(scoreDto);
        }

        ScoreListDto scoreListDto = new ScoreListDto(scoreDtoList);
        return scoreListDto;
    }
}
