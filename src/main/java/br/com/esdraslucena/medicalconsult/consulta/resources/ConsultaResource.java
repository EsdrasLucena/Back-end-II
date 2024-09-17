package br.com.esdraslucena.medicalconsult.consulta.resources;


import br.com.esdraslucena.medicalconsult.consulta.domain.Consulta;
import br.com.esdraslucena.medicalconsult.consulta.services.ConsultaService;
import br.com.esdraslucena.medicalconsult.usuario.domain.Usuario;
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

    /*@GetMapping
    public ResponseEntity<List<Consulta>> listarConsulta(){
        List<Consulta> consulta = consultaService.listarConsulta();
        return ResponseEntity.ok().body(consulta);
    }*/
}
