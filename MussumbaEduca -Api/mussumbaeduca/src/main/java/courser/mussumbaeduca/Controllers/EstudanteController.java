package courser.mussumbaeduca.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import courser.mussumbaeduca.Models.*;
import courser.mussumbaeduca.Services.EstudanteService;
import java.sql.Date;
import java.util.*;;

@RestController
@RequestMapping("/MussumbaEduca/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteService estudanteService;
    
    @GetMapping
    public List<Estudante> getAllEstudante()
    {
        return estudanteService.getAllEstudante();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> getEstudanteById(@PathVariable Long id) {
        Optional<Estudante> estudante=estudanteService.getEstudanteById(id);
        if (estudante.isPresent()) {
            return ResponseEntity.ok(estudante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Estudante AdicionarEstudante(@RequestBody Estudante estudante)
    {
        return estudanteService.saveEstudante(estudante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> updateEstudante(@PathVariable Long id, @RequestBody Estudante estudanteEditar) {
        Optional<Estudante> estudante = estudanteService.getEstudanteById(id);
        if (estudante.isPresent()) {
            Estudante estudanteUpadate= estudante.get();
            estudanteUpadate.setNome(estudanteEditar.getNome());
            estudanteUpadate.setDataNascimento(estudanteEditar.getDataNascimento());
            estudanteUpadate.setDataPagamento(estudanteEditar.getDataPagamento());
            estudanteUpadate.setEmail(estudanteEditar.getEmail());
            estudanteService.saveEstudante(estudanteUpadate);
            return ResponseEntity.ok(estudanteEditar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudante(@PathVariable Long id) {
        if (estudanteService.getEstudanteById(id).isPresent()) {
            estudanteService.deleteEstudante(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pagamento-anterior/{data}")
    public List<Estudante> getEstudantesComPagamentoAnteriorA(@PathVariable Date data) {
        return estudanteService.getEstudantesComPagamentoAnteriorA(data);
    }

}
