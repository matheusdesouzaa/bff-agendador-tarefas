package com.matheus.bffagendadortarefas.business;


import com.matheus.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.matheus.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.matheus.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.matheus.bffagendadortarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {
        return tarefasClient.gravarTarefa(dto, token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorPeriodo(LocalDateTime dataInicial,
                                                            LocalDateTime dataFinal,
                                                            String token) {
        return tarefasClient.buscarListaDeTarefasPorPeriodo(dataInicial,dataFinal,token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorEmail(String token) {
        return tarefasClient.buscarTarefaPorEmail(token);
    }

    public void deletaPorId(String id, String token) {
        tarefasClient.deletarPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alterarStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefa(TarefasDTORequest dto, String id, String token) {
        return tarefasClient.updateDeTarefa(dto, id, token);
    }
}
