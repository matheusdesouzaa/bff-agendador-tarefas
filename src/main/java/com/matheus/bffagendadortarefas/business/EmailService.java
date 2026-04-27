package com.matheus.bffagendadortarefas.business;


import com.matheus.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.matheus.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {
         emailClient.enviarEmail(dto);
    }

}
