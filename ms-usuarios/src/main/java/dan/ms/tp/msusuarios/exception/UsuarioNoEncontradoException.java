package dan.ms.tp.msusuarios.exception;

public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(Integer id) {
        super("El usuario con id " + id + " no ha sido encontrado.");
    }
}
