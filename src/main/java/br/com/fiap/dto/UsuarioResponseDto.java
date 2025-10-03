package br.com.fiap.dto;

import br.com.fiap.models.Usuario;

public class UsuarioResponseDto {
    private String nome;
    private String login;

    public UsuarioResponseDto converterDto(Usuario usuario){
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setNome(usuario.getNome());
        dto.setLogin(usuario.getLogin());

        return dto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
