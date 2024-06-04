package com.infnet.tp3sb.controller;

import com.infnet.tp3sb.model.Curso;
import com.infnet.tp3sb.model.MaterialDidatico;
import com.infnet.tp3sb.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materiais-didaticos")
public class MaterialDidaticoController {
    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    @PostMapping
    public MaterialDidatico criarMaterialDidatico(@RequestBody MaterialDidatico materialDidatico) {
        return materialDidaticoService.save(materialDidatico);
    }

    @GetMapping
    public List<MaterialDidatico> obterTodosMateriaisDidaticos() {
        return materialDidaticoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDidatico> obterMaterialDidaticoPorId(@PathVariable String id) {
        Optional<MaterialDidatico> material = materialDidaticoService.findById(id);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public MaterialDidatico atualizarMaterialDidatico(@PathVariable String id, @RequestBody MaterialDidatico materialDidatico) {
        return materialDidaticoService.update(id, materialDidatico);
    }

    @DeleteMapping("/{id}")
    public void removerMaterialDidatico(@PathVariable String id) {
        materialDidaticoService.deleteById(id);
    }
}
