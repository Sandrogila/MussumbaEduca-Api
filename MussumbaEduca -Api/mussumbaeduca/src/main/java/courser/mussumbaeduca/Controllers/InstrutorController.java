package courser.mussumbaeduca.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import courser.mussumbaeduca.Models.Instrutor;
import courser.mussumbaeduca.Services.InstrutorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MussumbaEduca/instrutores")
public class InstrutorController {
    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    public List<Instrutor> getAllInstrutores() {
        return instrutorService.GetAllInstrutor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getInstrutorById(@PathVariable Long id) {
        Optional<Instrutor> instrutor = instrutorService.GetInstrutorById(id);
        if (instrutor.isPresent()) {
            return ResponseEntity.ok(instrutor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Instrutor createInstrutor(@RequestBody Instrutor instrutor) {
        return instrutorService.saveInstrutor(instrutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> updateInstrutor(@PathVariable Long id, @RequestBody Instrutor instrutorDetails) {
        Optional<Instrutor> instrutor = instrutorService.GetInstrutorById(id);
        if (instrutor.isPresent()) {
            Instrutor instrutorToUpdate = instrutor.get();
            instrutorToUpdate.setNome(instrutorDetails.getNome());
            instrutorService.saveInstrutor(instrutorToUpdate);
            return ResponseEntity.ok(instrutorToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrutor(@PathVariable Long id) {
        if (instrutorService.GetInstrutorById(id).isPresent()) {
            instrutorService.deleteInstrutor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
