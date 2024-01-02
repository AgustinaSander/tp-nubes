package dan.ms.tp.msusuarios.modelo;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Echo {
    
    private Instant timestamp;
    private String server;
    private String metodo;
    private String urlRequest;
    private String id;
    private String payload;

    public Echo(){
        timestamp = Instant.now();
        id = UUID.randomUUID().toString();
    }

}
