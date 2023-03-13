
package com.usuario.service.servicio;

import com.usuario.service.Modelos.Carro;
import com.usuario.service.Modelos.Moto;
import com.usuario.service.Repositorio.UsuarioRepository;
import com.usuario.service.entidades.Usuario;
import com.usuario.service.feingclients.CarroFeingClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CarroFeingClient carroFeingClient;
    
    public List<Carro> getCarros(int usuarioId){
        List<Carro> carros = restTemplate.getForObject("http://localhost:8083/carro/usuario/" + usuarioId, List.class);
        return carros;
    }
    
     public List<Moto> getMotos(int usuarioId){
        List<Moto> motos = restTemplate.getForObject("http://localhost:8084/moto/usuario/" + usuarioId, List.class);
        return motos;
    }
     
     //Guardar un carro utilizando Feing
     public Carro saveCarro(int usuarioId, Carro carro){
         carro.setUsuarioId(usuarioId);
        Carro nuevoCarro = carroFeingClient.save(carro);
        return nuevoCarro;
     }
    
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }
    
    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }
    
    public Usuario save (Usuario usuario){
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }
    
}
