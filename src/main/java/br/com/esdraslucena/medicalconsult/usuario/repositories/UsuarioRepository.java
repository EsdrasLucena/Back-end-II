package br.com.esdraslucena.medicalconsult.usuario.repositories;

import br.com.esdraslucena.medicalconsult.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //declarando que ele é meu repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
