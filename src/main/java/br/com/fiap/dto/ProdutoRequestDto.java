package br.com.fiap.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

//na hora do cadastro, por segurança fazemos o DTO que faz a comunicação entre
@XmlRootElement /// Pro java entender que é para manipular os dados com o navegador
public class ProdutoRequestDto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
