package courser.mussumbaeduca.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courser.mussumbaeduca.Models.Instrutor;
import courser.mussumbaeduca.Repository.InstrutorRepository;
@Service
public class InstrutorService {
    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<Instrutor> GetAllInstrutor()
    {
        return instrutorRepository.findAll();   
    }

    public Optional<Instrutor> GetInstrutorById(long Id){
        return instrutorRepository.findById(Id);
    }

    public Instrutor saveInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public void deleteInstrutor(Long id) {
        instrutorRepository.deleteById(id);
    }
}