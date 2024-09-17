package br.com.esdraslucena.medicalconsult.consulta.services;

import br.com.esdraslucena.medicalconsult.consulta.domain.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private br.com.esdraslucena.medicalconsult.consulta.respositories.ConsultaRepository ConsultaRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return ConsultaRepository.save(consulta);
    }
}
