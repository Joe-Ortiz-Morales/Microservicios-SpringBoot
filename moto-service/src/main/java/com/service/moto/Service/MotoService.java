
package com.service.moto.Service;

import com.service.moto.Respository.MotoRepository;
import com.service.moto.entidades.Moto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService {
    
    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getAll() {
        return motoRepository.findAll();
    }

    public Moto getMotoById(int id) {
        return motoRepository.findById(id).orElse(null);
    }

    public Moto save(Moto moto) {
        Moto nuevaMoto = motoRepository.save(moto);
        return nuevaMoto;
    }

    public List<Moto> byUsuarioId(int usuarioId) {
        return motoRepository.findByUsuarioId(usuarioId);
    }
    
}
