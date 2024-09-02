package br.com.esdraslucena.medicalconsult.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.Date;

@Data //gera os getters e setters
@Entity //é uma entidade no meu banco de dados
@Table(name = "USUARIOS") // estou definindo como sendo uma tabela no meu banco

public class Usuario {
    @Id // valor unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incrementacao +1
    @Column(name = "ID_USUARIO") //declaro coluna de nome id_usuario
    private Long idUsuario;
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    //private Permissao permissao;


    //Construtor com variaveis
    public Usuario(Long idUsuario, String nomeUsuario, String email, String cpf, String telefone, Date dataNascimento) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() { //Construtor vazio
    }
}
