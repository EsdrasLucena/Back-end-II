package br.com.esdraslucena.medicalconsult.usuario.domain;

import br.com.esdraslucena.medicalconsult.consulta.domain.Consulta;
import jakarta.persistence.*;
import lombok.Data;

import java.security.Permission;
import java.util.Date;
import java.util.List;

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
    @Column(name="PERMISSAO")
    private Permissao permissao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    //Construtor com variaveis
    public Usuario(Long idUsuario, String nomeUsuario, String email, String cpf, String telefone, Date dataNascimento, Permissao permissao) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.permissao = permissao;
    }

    public Usuario() { //Construtor vazio
    }
}
