package com.outsideSong.outsideSong.service;
import com.outsideSong.outsideSong.dto.*;
import com.outsideSong.outsideSong.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.outsideSong.outsideSong.domain.Note;
import com.outsideSong.outsideSong.domain.Score;
import com.outsideSong.outsideSong.dto.NoteInsertRequestDto;
import com.outsideSong.outsideSong.repository.NoteRepository;
import com.outsideSong.outsideSong.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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

    // 노트 리스트 조회
    public List<NoteListResponseDto> getNoteList(Long scoreId) {

        Optional<Score> foundScore = scoreRepository.findById(scoreId);
        if (!foundScore.isPresent()) throw new NullPointerException("존재하지 않는 악보입니다");

        List<NoteListResponseDto> responseDto = new ArrayList<>();
        List<Note> noteList = noteRepository.findAllByScoreId(scoreId);

        for (int i=0; i<=63; i++) {
            NoteListResponseDto dto = null;
            for (Note note : noteList) {
                if (i == note.getIndex()) {
                    Long noteId = note.getId();
                    String userNick = note.getUserNick();
                    String content = note.getContent();
                    FixNote foundNote = FixNote.getNote(i);
                    String pitch = foundNote.getPitch();
                    String beat = foundNote.getBeat();
                    String color = foundNote.getColor();

                    dto = new NoteListResponseDto(scoreId, noteId, userNick, content, new String[]{pitch, beat}, i, color, true);
                    break;
                }
            }

            if (dto != null) responseDto.add(dto);
            else responseDto.add(new NoteListResponseDto(scoreId, 0L, null, null, new String[]{}, i, null, false));
        }

        return responseDto;
    }
}
