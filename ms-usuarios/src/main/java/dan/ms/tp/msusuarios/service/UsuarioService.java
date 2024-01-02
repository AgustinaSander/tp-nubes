package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import dan.ms.tp.msusuarios.modelo.Usuario;

import java.util.List;
public interface UsuarioService {
    Usuario getUsuarioById(Integer id);
    List<Usuario> getUsuarioListByCliente(Cliente cliente);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Integer id);
    Usuario updateUsuario(Usuario usuario);
    List<Usuario> getUsuarioListByClienteByTipoUsuario(Cliente cliente, TipoUsuario tipoUsuario);

    //La clave del usuario debe tener al menos 12 caracteres, y debe contener al menos una mayúscula, una minúscula, un número y un carácter especial
    boolean validatePassword(String password);
}
