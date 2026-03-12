package com.otavio.voleimanager.service;

import com.otavio.voleimanager.repository.TimeRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    //Atributos
    private final TimeRepository timeRepository;

    //Construtor
    public TimeService(TimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }

    //Métodos


}
