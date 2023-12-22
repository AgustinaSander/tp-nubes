package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.modelo.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario getUsuarioById(Integer id);
    List<Usuario> getUsuarioListByClienteId(Integer clienteId);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Integer id);
    Usuario updateUsuario(Usuario usuario);
    List<Usuario> getUsuarioListByClienteByTipoUsuario(Integer clienteId, Integer tipoId);
}
