package com.infnet.tp3sb.service;

import com.infnet.tp3sb.model.Curso;
import com.infnet.tp3sb.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Cacheable(value = "cursos")
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Cacheable(value = "cursos", key = "#id")
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @CacheEvict(value = "produtos", key = "#id")
    public Curso update(Long id, Curso cursoDetails) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            Curso updatedCurso = curso.get();
            updatedCurso.setNome(cursoDetails.getNome());
            return cursoRepository.save(updatedCurso);
        } else {
            return null;
        }
    }

    @CacheEvict(value = "produtos", key = "#id")
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}
