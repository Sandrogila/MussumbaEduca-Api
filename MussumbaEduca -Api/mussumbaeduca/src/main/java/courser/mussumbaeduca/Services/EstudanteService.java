package courser.mussumbaeduca.Services;



import java.sql.Date;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import courser.mussumbaeduca.Models.*;
import courser.mussumbaeduca.Repository.EstudanteRepository;

@Service
public class EstudanteService {
    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> getAllEstudante()
    {
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> getEstudanteById(Long Id)
    {
        return estudanteRepository.findById(Id);
    }

    public Estudante saveEstudante(Estudante estudante)
    {
        return estudanteRepository.save(estudante);
    }
    
    public void deleteEstudante(Long Id)
    {
         estudanteRepository.deleteById(Id);
    }

    public List<Estudante> getEstudantesComPagamentoAnteriorA(Date data) {
        return estudanteRepository.findByDataPagamentoBefore(data);
    }



}
