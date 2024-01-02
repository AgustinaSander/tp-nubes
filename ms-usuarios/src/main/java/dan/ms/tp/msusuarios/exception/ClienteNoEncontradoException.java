package dan.ms.tp.msusuarios.exception;

public class ClienteNoEncontradoException extends RuntimeException{
    public ClienteNoEncontradoException(Integer id){
        super("El cliente con id "+ id +" no ha sido encontrado.");
    }
    public ClienteNoEncontradoException(String cuit){
        super("El cliente con cuit "+ cuit +" no ha sido encontrado.");
    }
}
