package courser.mussumbaeduca.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import courser.mussumbaeduca.Models.CursoEstudanteId;
import courser.mussumbaeduca.Models.Curso_Estudante;

@Repository
public interface Curso_EstudantesRepository extends JpaRepository<Curso_Estudante, CursoEstudanteId> {
    List<Curso_Estudante> findByCursoId(Long cursoId);
    List<Curso_Estudante> findByEstudanteId(Long estudanteId);
}
