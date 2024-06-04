package com.infnet.tp3sb;

import com.infnet.tp3sb.model.Aluno;
import com.infnet.tp3sb.model.Curso;
import com.infnet.tp3sb.repository.AlunoRepository;
import com.infnet.tp3sb.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void run(String... args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setNome("Matemática");

        Curso curso2 = new Curso();
        curso2.setNome("História");
        cursoRepository.save(curso1);
        cursoRepository.save(curso2);

        Aluno aluno1 = new Aluno();
        aluno1.setNome("João");
        aluno1.addCurso(curso1);
        aluno1.addCurso(curso2);

       // curso1.getAlunos().add(aluno1);
       // curso2.getAlunos().add(aluno1);

        alunoRepository.save(aluno1);
    }
}
