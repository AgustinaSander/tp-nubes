package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.modelo.TipoUsuario;

import java.util.List;

public interface TipoUsuarioService {
    TipoUsuario getTipoUsuarioById(Integer tipoId);

    List<TipoUsuario> getTipoUsuarioList();
}
