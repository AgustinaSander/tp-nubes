package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.dao.ClienteJpaRepository;
import dan.ms.tp.msusuarios.dao.UsuarioJpaRepository;
import dan.ms.tp.msusuarios.exception.UsuarioNoEncontradoException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import dan.ms.tp.msusuarios.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Override
    public Usuario getUsuarioById(Integer id){
        Optional<Usuario> usuario = usuarioJpaRepository.findById(id);
        return usuario.orElseThrow(() -> new UsuarioNoEncontradoException(id));
    }

    @Override
    public List<Usuario> getUsuarioListByClienteId(Integer clienteId) {
        Cliente cliente = clienteService.getClienteById(clienteId);
        return usuarioJpaRepository.findAllByCliente(cliente);
    }

    @Override
    public List<Usuario> getUsuarioListByClienteByTipoUsuario(Integer clienteId, Integer tipoId) {
        Cliente cliente = clienteService.getClienteById(clienteId);
        TipoUsuario tipoUsuario = tipoUsuarioService.getTipoUsuarioById(tipoId);
        return usuarioJpaRepository.findAllByClienteByTipoUsuario(cliente, tipoUsuario);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioJpaRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioJpaRepository.deleteById(id);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioJpaRepository.save(usuario);
    }
}
