package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.modelo.Cliente;

public interface ClienteService {
    Cliente getClienteById(Integer id);

    Cliente getClienteByCuit(String cuit);

    Cliente createCliente(Cliente cliente);

    void deleteCliente(Integer id);

    Cliente updateCliente(Cliente cliente);
    boolean hasGerente(Integer clienteId);
}
