package dan.ms.tp.msusuarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dan.ms.tp.msusuarios.modelo.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente,Integer> {
    Optional<Cliente> findByCuit(String cuit);
}
