package dan.ms.tp.msusuarios.rest;

import dan.ms.tp.msusuarios.exception.ClienteNoEncontradoException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }
    @GetMapping
    public ResponseEntity<Cliente> getClienteByCuit(@RequestParam String cuit){
        return ResponseEntity.ok(clienteService.getClienteByCuit(cuit));
    }
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.createCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Integer id){
        clienteService.deleteCliente(id);
    }

    @PatchMapping
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.updateCliente(cliente));
    }

}
