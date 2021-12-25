package com.outsideSong.outsideSong;

import com.outsideSong.outsideSong.domain.Note;
import com.outsideSong.outsideSong.domain.Score;
import com.outsideSong.outsideSong.repository.ScoreRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;


@Component
@NoArgsConstructor
public class SimpleListener implements ApplicationListener<ApplicationStartedEvent> {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Score score = null;
        for (int i = 0; i < 9; i++) {
            score = new Score();
            em.persist(score);
        }

        for (int i = 0; i<64; i++){
            if(i % 9==0) {
                Note note = new Note("testNick", "1234", "Merry Chrismas", i, score);
                em.persist(note);
            }
        }
        em.getTransaction().commit();
    }
}
