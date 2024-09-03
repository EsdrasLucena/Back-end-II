package br.com.esdraslucena.medicalconsult.usuario.resources;

import br.com.esdraslucena.medicalconsult.usuario.domain.Usuario;
import br.com.esdraslucena.medicalconsult.usuario.services.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService; //injetando depedencia

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
       List<Usuario> usuarios = usuarioService.listarUsuarios();
       return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping(value = "/{id}") //é um get mas tem que dizer que recebe id
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id){ //path variable pq recebe id no getmapping
        Usuario usuario = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok().body(usuario);
    }


}
