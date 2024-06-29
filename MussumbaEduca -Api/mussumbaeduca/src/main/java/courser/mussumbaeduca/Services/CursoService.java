package courser.mussumbaeduca.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courser.mussumbaeduca.Models.Curso;
import courser.mussumbaeduca.Repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public List<Curso> getCursosComPrecoMenorQue(double preco) {
        return cursoRepository.findByPrecoLessThan(preco);
    }

    public List<Curso> getCursosDoInstrutor(Long instrutorId) {
        return cursoRepository.findByInstrutorId(instrutorId);
    }


}
