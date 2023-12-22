package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.dao.UsuarioJpaRepository;
import dan.ms.tp.msusuarios.exception.UsuarioNoEncontradoException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import dan.ms.tp.msusuarios.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Override
    public Usuario getUsuarioById(Integer id){
        Optional<Usuario> usuario = usuarioJpaRepository.findById(id);
        return usuario.orElseThrow(() -> new UsuarioNoEncontradoException(id));
    }

    @Override
    public List<Usuario> getUsuarioListByCliente(Cliente cliente) {
        return usuarioJpaRepository.findAllByCliente(cliente);
    }

    @Override
    public List<Usuario> getUsuarioListByClienteByTipoUsuario(Cliente cliente, TipoUsuario tipoUsuario) {
        return usuarioJpaRepository.findAllByClienteAndTipoUsuario(cliente, tipoUsuario);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioJpaRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioJpaRepository.deleteById(id);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Optional<Usuario> usuarioDb = usuarioJpaRepository.findById(usuario.getId());
        if(!usuarioDb.isPresent()){
            throw new UsuarioNoEncontradoException(usuario.getId());
        }
        Usuario u = usuarioDb.get();
        u.setTipoUsuario(usuario.getTipoUsuario());
        u.setCliente(usuario.getCliente());
        u.setPassword(usuario.getPassword());
        u.setUserName(usuario.getUserName());
        u.setCorreoElectronico(usuario.getCorreoElectronico());
        return usuarioJpaRepository.save(u);
    }

    //La clave del usuario debe tener al menos 12 caracteres, y debe contener al menos una mayúscula, una minúscula, un número y un carácter especial
    @Override
    public boolean validatePassword(String password){
        boolean valid = password.length() >= 12;
        String regexUppercase = ".*[A-Z]+.*";
        String regexLowercase = ".*[a-z]+.*";
        String regexNumber = ".*[0-9]+.*";
        String regexSpecialCharacter = ".*[^a-zA-Z0-9]+.*";

        List<String> regexs = List.of(regexUppercase, regexLowercase, regexNumber, regexSpecialCharacter);
        for (String r : regexs){
            Pattern pattern = Pattern.compile(r);
            Matcher matcher = pattern.matcher(password);
            valid = valid && matcher.matches();
        };
        return valid;
    }
}
