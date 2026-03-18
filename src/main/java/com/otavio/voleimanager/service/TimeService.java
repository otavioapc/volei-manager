package com.otavio.voleimanager.service;

import com.otavio.voleimanager.dto.TimeRequestDTO;
import com.otavio.voleimanager.dto.TimeResponseDTO;
import com.otavio.voleimanager.entity.Time;
import com.otavio.voleimanager.repository.TimeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    //Atributos
    private final TimeRepository timeRepository;

    //Construtor
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    //Métodos

    public TimeResponseDTO criarTime(TimeRequestDTO request) {

        //Validar regra de negócio
        if (timeRepository.existsByNomeAndCidade(request.getNome(), request.getCidade())) {
            throw new RuntimeException("Já existe um time com esse nome nessa cidade");
        }

        //Converter DTO em Entidade
        Time time = new Time();
        time.setNome(request.getNome());
        time.setCidade(request.getCidade());
        time.setEstado(request.getEstado());

        //Salvar no banco
        Time timeSalvo;
        try {
            timeSalvo = timeRepository.save(time);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe time com mesmo nome nesta cidade", e);

        }

        //Converte Time em ResponseDTO
        TimeResponseDTO response = new TimeResponseDTO();
        response.setId(timeSalvo.getId());
        response.setNome(timeSalvo.getNome());
        response.setCidade(timeSalvo.getCidade());
        response.setEstado(timeSalvo.getEstado());

        return response;

    }


}
