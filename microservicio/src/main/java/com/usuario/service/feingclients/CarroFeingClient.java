
package com.usuario.service.feingclients;

import com.usuario.service.Modelos.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//Indicamos el nombre del microservicio y su url
@FeignClient(name = "carro-service", url = "http://localhost:8083")
@RequestMapping("/carro")
public interface CarroFeingClient {
    
    //Guarda un carro
    @PostMapping()
    public Carro save (@RequestBody Carro carro);
    
}
