package courser.mussumbaeduca.Services;

import courser.mussumbaeduca.Models.Curso;
import courser.mussumbaeduca.Models.Estudante;
import courser.mussumbaeduca.Models.Curso_Estudante;
import courser.mussumbaeduca.Repository.Curso_EstudantesRepository;
import courser.mussumbaeduca.Repository.CursoRepository;
import courser.mussumbaeduca.Repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Curso_EstudanteService {

    @Autowired
    private Curso_EstudantesRepository curso_EstudanteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    // Método para obter todos os registros de Curso_Estudante
    public List<Curso_Estudante> getAll() {
        return curso_EstudanteRepository.findAll();
    }

    // Método para obter todos os registros de Curso_Estudante por ID do curso
    public List<Curso_Estudante> getCurso_Estudante_ByIdCurso(Long idCurso) {
        return curso_EstudanteRepository.findByCursoId(idCurso);
    }

    // Método para obter todos os registros de Curso_Estudante por ID do estudante
    public List<Curso_Estudante> getCurso_Estudante_ByIdEstudante(Long idEstudante) {
        return curso_EstudanteRepository.findByEstudanteId(idEstudante);
    }

    // Método para adicionar um estudante a um curso
    public Curso_Estudante adicionarEstudanteEmCurso(Long idCurso, Long idEstudante) {
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        Optional<Estudante> estudanteOpt = estudanteRepository.findById(idEstudante);

        if (cursoOpt.isPresent() && estudanteOpt.isPresent()) {
            Curso_Estudante cursoEstudante = new Curso_Estudante();
            cursoEstudante.setCurso(cursoOpt.get());
            cursoEstudante.setEstudante(estudanteOpt.get());
            return curso_EstudanteRepository.save(cursoEstudante);
        } else {
            throw new IllegalArgumentException("Curso ou Estudante não encontrado");
        }
    }
}
 