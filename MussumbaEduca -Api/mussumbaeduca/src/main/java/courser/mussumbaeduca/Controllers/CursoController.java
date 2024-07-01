package courser.mussumbaeduca.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import courser.mussumbaeduca.Models.Curso;
import courser.mussumbaeduca.Services.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MussumbaEduca/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.getCursoById(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Optional<Curso> curso = cursoService.getCursoById(id);
        if (curso.isPresent()) {
            Curso cursoToUpdate = curso.get();
            cursoToUpdate.setTitulo(cursoDetails.getTitulo());
            cursoToUpdate.setPreco(cursoDetails.getPreco());
            cursoToUpdate.setDatainicio(cursoDetails.getDatainicio());
            cursoToUpdate.setInstrutor(cursoDetails.getInstrutor());
            cursoService.saveCurso(cursoToUpdate);
            return ResponseEntity.ok(cursoToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        if (cursoService.getCursoById(id).isPresent()) {
            cursoService.deleteCurso(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/preco-menor/{preco}")
    public List<Curso> getCursosComPrecoMenorQue(@PathVariable double preco) {
        return cursoService.getCursosComPrecoMenorQue(preco);
    }

    @GetMapping("/instrutor/{instrutorId}")
    public List<Curso> getCursosDoInstrutor(@PathVariable Long instrutorId) {
        return cursoService.getCursosDoInstrutor(instrutorId);
    }


}
