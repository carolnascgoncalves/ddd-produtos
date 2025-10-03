package br.com.fiap.service;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dto.UsuarioRequestDto;
import br.com.fiap.dto.UsuarioResponseDto;
import br.com.fiap.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private UsuarioDao usuarioDao = new UsuarioDao();

    public void inserir(UsuarioRequestDto usuario){
        usuarioDao.inserir(usuario);
    }

    public UsuarioResponseDto buscarId(int id){
        return usuarioDao.buscarPorId(id);
    }

    public List<Usuario> listar(){
        return usuarioDao.listar();
    }
}
