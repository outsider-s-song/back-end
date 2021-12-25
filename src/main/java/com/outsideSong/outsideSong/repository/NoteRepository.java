package com.outsideSong.outsideSong.repository;

import com.outsideSong.outsideSong.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select n from Note n where n.index = :index and n.score.id = :scoreId")
    Optional<Note> findByIndexAndScoreId(int index, Long scoreId);
}
