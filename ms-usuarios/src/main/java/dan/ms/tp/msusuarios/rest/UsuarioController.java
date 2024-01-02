package dan.ms.tp.msusuarios.rest;

import dan.ms.tp.msusuarios.exception.ClienteNoPuedeTenerMasGerentes;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import dan.ms.tp.msusuarios.modelo.Usuario;
import dan.ms.tp.msusuarios.service.ClienteService;
import dan.ms.tp.msusuarios.service.TipoUsuarioService;
import dan.ms.tp.msusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @GetMapping("/pass/{pass}")
    public boolean validate(@PathVariable String pass){
        return usuarioService.validatePassword(pass);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }
    @GetMapping("/cliente")
    public ResponseEntity<List<Usuario>> getUsuarioListByClienteId(@RequestParam Integer id){
        Cliente cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(usuarioService.getUsuarioListByCliente(cliente));
    }
    @GetMapping("/cliente-tipo")
    public ResponseEntity<List<Usuario>> getUsuarioListByClienteByTipoUsuario(@RequestParam Integer clienteId, @RequestParam Integer tipoId){
        Cliente cliente = clienteService.getClienteById(clienteId);
        TipoUsuario tipoUsuario = tipoUsuarioService.getTipoUsuarioById(tipoId);
        return ResponseEntity.ok(usuarioService.getUsuarioListByClienteByTipoUsuario(cliente, tipoUsuario));
    }
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        boolean isGerente = usuario.getTipoUsuario().getTipo().equals("GERENTE");
        if(isGerente && clienteService.hasGerente(usuario.getCliente().getId())){
                throw new ClienteNoPuedeTenerMasGerentes(usuario.getCliente().getId());
        }

        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Integer id){
        usuarioService.deleteUsuario(id);
    }

    @PatchMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        boolean isGerente = usuario.getTipoUsuario().getTipo().equals("GERENTE");
        if(isGerente && clienteService.hasGerente(usuario.getCliente().getId())){
            throw new ClienteNoPuedeTenerMasGerentes(usuario.getCliente().getId());
        }

        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }
}
