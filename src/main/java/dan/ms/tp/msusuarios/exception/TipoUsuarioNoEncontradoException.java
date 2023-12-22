package dan.ms.tp.msusuarios.exception;

public class TipoUsuarioNoEncontradoException extends RuntimeException {
    public TipoUsuarioNoEncontradoException(Integer id) {
        super("El tipo de usuario con id " + id + " no ha sido encontrado.");
    }
}
