package com.courseori.server.participants.service;

import com.courseori.server.participants.Participants;
import com.courseori.server.participants.repository.ParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantsServiceImpl implements ParticipantsService{

    private ParticipantsRepository participantsRepository;

    @Autowired
    public ParticipantsServiceImpl(ParticipantsRepository participantsRepository) {
        this.participantsRepository = participantsRepository;
    }

    @Override
    public Participants createParticipants(Participants participants) {

        return participantsRepository.save(participants);

    }

}
