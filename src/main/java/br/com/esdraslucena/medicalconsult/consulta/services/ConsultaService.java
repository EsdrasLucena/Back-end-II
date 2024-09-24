package br.com.esdraslucena.medicalconsult.consulta.services;

import br.com.esdraslucena.medicalconsult.consulta.domain.Consulta;
import br.com.esdraslucena.medicalconsult.usuario.domain.Usuario;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private br.com.esdraslucena.medicalconsult.consulta.respositories.ConsultaRepository ConsultaRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return ConsultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas(){ //public que retorna lista de usuario
        return ConsultaRepository.findAll();
    }

    public Consulta buscarConsulta (Long id){ //public que retorna consulta recebendo id de parametro
        Optional<Consulta> consulta = ConsultaRepository.findById(id);
        return consulta.orElseThrow(
                () -> new ObjectNotFoundException("Especialidade não encontrada! ID: ", id));
        /*return ConsultaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Consulta nao encontrada: ", id));*/
    }

    public void deletarConsulta (Long id){
        buscarConsulta(id);
        try{
            ConsultaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new ExceptionDataIntegrityViolationException("Não é possivel excluir, porque há entidades relacionadas");
        }

        /*
        Consulta consulta =  ConsultaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Consulta nao encontrada: ", id)
        );
        ConsultaRepository.deleteById(id);*/
    }

    public void updateData(Consulta upConsulta, Consulta consulta){
        upConsulta.setDataConsulta(consulta.getDataConsulta());
        upConsulta.setEspecialidade(consulta.getEspecialidade());
        upConsulta.setProfissional(consulta.getProfissional());
    }

    public Consulta atualizarConsulta (Consulta consulta){
        Consulta upConsulta = buscarConsulta(consulta.getIdConsulta());
        updateData(upConsulta, consulta);
        return ConsultaRepository.save(upConsulta);

        /*
        Consulta upConsulta = buscarConsulta(consulta.getIdConsulta());
        upConsulta.setDataConsulta(consulta.getDataConsulta());
        upConsulta.setEspecialidade(consulta.getEspecialidade());
        upConsulta.setProfissional(consulta.getProfissional());
        */

    }
}
