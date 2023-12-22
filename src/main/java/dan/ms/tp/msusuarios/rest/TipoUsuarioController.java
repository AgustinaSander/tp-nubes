package dan.ms.tp.msusuarios.rest;

import java.util.List;

import dan.ms.tp.msusuarios.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msusuarios.dao.TipoUsuarioJpaRepository;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;

@RestController
@RequestMapping("api/tipo-usuario")
public class TipoUsuarioController {
 
    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> getTipoUsuarioList(){
        return ResponseEntity.ok().body(tipoUsuarioService.getTipoUsuarioList());
    }
}
