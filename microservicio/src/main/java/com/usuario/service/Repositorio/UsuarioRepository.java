
package com.usuario.service.Repositorio;

import com.usuario.service.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
