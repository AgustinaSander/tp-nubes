package dan.ms.tp.msusuarios.dao;

import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.Usuario;

import java.util.List;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Integer>{
    List<Usuario> findAllByCliente(Cliente cliente);
    List<Usuario> findAllByClienteByTipoUsuario(Cliente cliente, TipoUsuario tipoUsuario);
}
