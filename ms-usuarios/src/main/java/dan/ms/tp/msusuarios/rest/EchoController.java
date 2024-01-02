package dan.ms.tp.msusuarios.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msusuarios.modelo.Echo;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/echo")
public class EchoController {
    
    private static final Logger log = LoggerFactory.getLogger("dan.ms.tp.msusuarios");
    private Echo getEcho(Echo echoReq,HttpServletRequest request){
        
        Echo respuesta = getEcho(request);
        respuesta.setPayload(echoReq.getPayload());
        return respuesta;
    }

    private Echo getEcho(HttpServletRequest request){
        log.debug("REQUEEST {}",request);
        Echo respuesta = new Echo();
        respuesta.setMetodo(request.getMethod());
        respuesta.setServer(request.getServerName()+" - "+request.getLocalAddr()+ " - "+request.getLocalName()+ " - "+request.getLocalPort());
        return respuesta;
    }

    @PostMapping
    public ResponseEntity<Echo> post(@RequestBody Echo echoReq,HttpServletRequest request){
        return ResponseEntity.ok().body(getEcho(echoReq, request));
    }

    @PutMapping
    public ResponseEntity<Echo> put(@RequestBody Echo echoReq,HttpServletRequest request){
        return ResponseEntity.ok().body(getEcho(echoReq, request));
    }

    @DeleteMapping
    public ResponseEntity<Echo> delete(HttpServletRequest request){
        return ResponseEntity.ok().body(getEcho(request));
    }

    @GetMapping
    public ResponseEntity<Echo> get(HttpServletRequest request){        
        return ResponseEntity.ok().body(getEcho(request));
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Echo> getId(@PathVariable String id,HttpServletRequest request){
        Echo respuesta = getEcho(request);
        respuesta.setPayload(id);
        return ResponseEntity.ok().body(respuesta);
    }
}
