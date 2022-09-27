package com.courseori.server.participants.repository;

import com.courseori.server.participants.Participants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantsRepository extends JpaRepository<Participants, Long> {
}
