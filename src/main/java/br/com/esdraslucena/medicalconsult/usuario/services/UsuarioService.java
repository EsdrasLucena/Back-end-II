package br.com.esdraslucena.medicalconsult.usuario.services;

import br.com.esdraslucena.medicalconsult.usuario.domain.Usuario;
import br.com.esdraslucena.medicalconsult.usuario.repositories.UsuarioRepository;
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


}
