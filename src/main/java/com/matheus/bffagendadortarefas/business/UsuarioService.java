package com.matheus.bffagendadortarefas.business;

import com.matheus.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.matheus.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.matheus.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.matheus.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.matheus.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.matheus.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.matheus.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.matheus.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){

        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto){
        return usuarioClient.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuarioPorEmail(email,token);
    }

    public void deletaPorEmail(String email,String token){
        usuarioClient.deletarPorEmail(email,token);
    }



    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest usuarioDTO){
        return usuarioClient.atualizaDadoUsuario(usuarioDTO,token);

    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return usuarioClient.atualizaEndereco(enderecoDTO,idEndereco,token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return usuarioClient.atualizaTelefone(telefoneDTO,idTelefone,token);
    }

    public EnderecoDTOResponse cadastroEndereco(String token, EnderecoDTORequest dto){
        return  usuarioClient.cadastraEndereco(dto,token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
       return usuarioClient.cadastraTelefone(dto,token);
    }

}
