package dan.ms.tp.msusuarios.exception;

public class ClienteNoPuedeTenerMasGerentes extends RuntimeException{
    public ClienteNoPuedeTenerMasGerentes(Integer clienteId){
        super("El cliente con id "+ clienteId +" ya tiene un usuario que es gerente.");
    }
}
