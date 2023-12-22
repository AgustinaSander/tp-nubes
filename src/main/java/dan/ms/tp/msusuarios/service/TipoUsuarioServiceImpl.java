package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.dao.TipoUsuarioJpaRepository;
import dan.ms.tp.msusuarios.exception.TipoUsuarioNoEncontradoException;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;

public class TipoUsuarioServiceImpl implements TipoUsuarioService{
    @Autowired
    private TipoUsuarioJpaRepository tipoUsuarioJpaRepository;

    @Override
    public TipoUsuario getTipoUsuarioById(Integer tipoId) {
        return tipoUsuarioJpaRepository.findById(tipoId).orElseThrow(() -> new TipoUsuarioNoEncontradoException(tipoId));
    }
}
