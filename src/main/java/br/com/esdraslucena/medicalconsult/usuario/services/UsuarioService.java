package br.com.esdraslucena.medicalconsult.usuario.services;

import br.com.esdraslucena.medicalconsult.usuario.domain.Usuario;
import br.com.esdraslucena.medicalconsult.usuario.repositories.UsuarioRepository;
import jakarta.persistence.Id;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){ //public que retorna usuario
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){ //public que retorna lista de usuario
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario (Long id){ //public que retorna usuario recebendo id de parametro
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuario nao encontrado: ", id));
    }

    public void deletarUsuario (Long id){
        Usuario usuario =  usuarioRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuario nao encontrado: ", id)
        );
          usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario (Long id, Usuario usuario){
        //Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));
        Usuario upUsuario = buscarUsuario(id);
        upUsuario.setNomeUsuario(usuario.getNomeUsuario());
        upUsuario.setEmail(usuario.getEmail());
        upUsuario.setCpf(usuario.getCpf());
        upUsuario.setTelefone(usuario.getTelefone());
        upUsuario.setDataNascimento(usuario.getDataNascimento());
        upUsuario.setPermissao(usuario.getPermissao());
        return usuarioRepository.save(upUsuario);
    }

}
