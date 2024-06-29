package courser.mussumbaeduca.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import courser.mussumbaeduca.Models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByPrecoLessThan(double preco);
    List<Curso> findByInstrutorId(Long instrutorId);


}
