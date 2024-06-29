package courser.mussumbaeduca.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import courser.mussumbaeduca.Models.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    List<Estudante> findByDataPagamentoBefore(Date data);
}