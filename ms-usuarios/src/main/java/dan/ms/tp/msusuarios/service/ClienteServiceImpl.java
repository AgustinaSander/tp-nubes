package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.dao.ClienteJpaRepository;
import dan.ms.tp.msusuarios.exception.ClienteNoEncontradoException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteJpaRepository clienteJpaRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Override
    public Cliente getClienteById(Integer id){
        Optional<Cliente> cliente = clienteJpaRepository.findById(id);
        return cliente.orElseThrow(() -> new ClienteNoEncontradoException(id));
    }

    @Override
    public Cliente getClienteByCuit(String cuit) {
        Optional<Cliente> cliente = clienteJpaRepository.findByCuit(cuit);
        return cliente.orElseThrow(() -> new ClienteNoEncontradoException(cuit));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteJpaRepository.deleteById(id);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }


    //Un cliente puede tener asignado solo un usuario de tipo GERENTE
    @Override
    public boolean hasGerente(Integer clienteId){
        Cliente cliente = getClienteById(clienteId);
        List<Usuario> usuarioList = usuarioService.getUsuarioListByCliente(cliente);
        return usuarioList.stream().anyMatch(u -> u.getTipoUsuario().getTipo().equals("GERENTE"));
    }
}
