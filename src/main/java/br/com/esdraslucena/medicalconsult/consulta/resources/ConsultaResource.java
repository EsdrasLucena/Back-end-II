package br.com.esdraslucena.medicalconsult.consulta.resources;


import br.com.esdraslucena.medicalconsult.consulta.domain.Consulta;
import br.com.esdraslucena.medicalconsult.consulta.services.ConsultaService;
import br.com.esdraslucena.medicalconsult.usuario.domain.Permissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaResource {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta (@RequestBody Consulta consulta){
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(novaConsulta);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsulta(){
        //List<Consulta> consulta = consultaService.listarConsultas();
        return ResponseEntity.ok().body(consultaService.listarConsultas());
    }

    @GetMapping(value = "/{id}") //é um get mas tem que dizer que recebe id
    public ResponseEntity<Consulta> buscarConsulta(@PathVariable Long id){ //path variable pq recebe id no getmapping
        Consulta consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok().body(consulta);
    }
/*
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id){
        Permissao permissaoUsuario = Permissao.ADMIN;
        consultaService.deletarConsulta(id, permissaoUsuario);
        return ResponseEntity.noContent().build();
    }*/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id, @RequestHeader("X-Usuario-Permissao") String permissaoUsuario) {
    // Verifica se a permissão do usuário é diferente de ADMIN
        if (!"ADMIN".equals(permissaoUsuario)) {
            throw new SecurityException("Usuário não tem permissão para realizar esta ação.");
    }
    // Passa a permissão e o id para o serviço
        consultaService.deletarConsulta(id, permissaoUsuario);
        return ResponseEntity.noContent().build();
}

    @PutMapping(value = "/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta){
        consulta.setIdConsulta(id);
        Consulta consultaAtualizada = consultaService.atualizarConsulta(consulta);
        return ResponseEntity.ok().body(consultaAtualizada);
    }
}
