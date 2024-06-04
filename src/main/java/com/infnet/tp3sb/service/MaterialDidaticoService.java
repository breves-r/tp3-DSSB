package com.infnet.tp3sb.service;

import com.infnet.tp3sb.model.MaterialDidatico;
import com.infnet.tp3sb.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public MaterialDidatico save(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);
    }

    public List<MaterialDidatico> findAll() {
        return materialDidaticoRepository.findAll();
    }

    public Optional<MaterialDidatico> findById(String id) {
        return materialDidaticoRepository.findById(id);
    }

    public MaterialDidatico update(String id, MaterialDidatico materialDidatico) {
        materialDidatico.setId(id);
        return materialDidaticoRepository.save(materialDidatico);
    }

    public void deleteById(String id) {
        materialDidaticoRepository.deleteById(id);
    }
}
