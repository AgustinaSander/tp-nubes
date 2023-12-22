package dan.ms.tp.msusuarios.rest;

import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.Usuario;
import dan.ms.tp.msusuarios.service.UsuarioService;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Usuario>> getUsuarioListByClienteId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.getUsuarioListByClienteId(id));
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarioListByClienteByTipoUsuario(@RequestParam Integer clienteId, @RequestParam Integer tipoId){
        return ResponseEntity.ok(usuarioService.getUsuarioListByClienteByTipoUsuario(clienteId, tipoId));
    }
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id){
        usuarioService.deleteUsuario(id);
    }

    @PatchMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }
}
