package br.com.fiap.dao;

import br.com.fiap.dto.UsuarioRequestDto;
import br.com.fiap.dto.UsuarioResponseDto;
import br.com.fiap.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private Connection conexao;

    public void inserir(UsuarioRequestDto usuario){
        PreparedStatement comandoSQL = null;
        conexao = ConnectionFactory.obterConexao();

        try{
            String sql = "insert into tbl_usuario(nome, login, senha) \n" +
                    "values(?,?,?)";
            comandoSQL = conexao.prepareStatement(sql);

            comandoSQL.setString(1, usuario.getNome());
            comandoSQL.setString(2, usuario.getLogin());
            comandoSQL.setString(3, usuario.getLogin());

            comandoSQL.executeUpdate();

            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(int id){
        PreparedStatement comandoSQL = null;
        conexao = ConnectionFactory.obterConexao();

        try{
            String sql = "delete from tbl_usuario where id = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);

            comandoSQL.executeUpdate();

            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public UsuarioResponseDto buscarPorId(int id){
        PreparedStatement comandoSQL = null;
        conexao = ConnectionFactory.obterConexao();
        Usuario usuario = new Usuario();

        try{
            String sql = "select * from tbl_usuario where id = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);

            ResultSet linha = comandoSQL.executeQuery();
            if(linha.next()){
                usuario.setId(linha.getInt(1));
                usuario.setNome(linha.getString(2));
                usuario.setLogin(linha.getString(3));
                usuario.setSenha(linha.getString(4));
            }


            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        UsuarioResponseDto dto = new UsuarioResponseDto();
        return dto.converterDto(usuario);
    }

    public List<Usuario> listar(){
        PreparedStatement comandoSQL = null;
        conexao = ConnectionFactory.obterConexao();
        List<Usuario> usuarios = new ArrayList<>();

        try{
            String sql = "select * from tbl_usuario";
            comandoSQL = conexao.prepareStatement(sql);

            ResultSet linha = comandoSQL.executeQuery();
            while(linha.next()){
                Usuario usuario = new Usuario();

                usuario.setId(linha.getInt(1));
                usuario.setNome(linha.getString(2));
                usuario.setLogin(linha.getString(3));
                usuario.setSenha(linha.getString(4));

                usuarios.add(usuario);
            }

            comandoSQL.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return usuarios;
    }
}
