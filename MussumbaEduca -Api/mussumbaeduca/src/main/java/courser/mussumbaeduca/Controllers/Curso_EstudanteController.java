package courser.mussumbaeduca.Controllers;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import courser.mussumbaeduca.Models.CursoEstudanteId;
import courser.mussumbaeduca.Models.Curso_Estudante;
import courser.mussumbaeduca.Services.Curso_EstudanteService;

@RestController
@RequestMapping("/MussumbaEduca/curso_estudantes")
public class Curso_EstudanteController {

    @Autowired
    private Curso_EstudanteService curso_EstudanteService;

    @GetMapping
    public List<Curso_Estudante> getAllCursoEstudantes() {
        return curso_EstudanteService.getAll();
    }

    @GetMapping("/cursos/{id}")
    public List<Curso_Estudante> getCursoEstudantesByCursoId(@PathVariable("id") Long id) {
        return curso_EstudanteService.getCurso_Estudante_ByIdCurso(id);
    }

    @GetMapping("/estudantes/{id}")
    public List<Curso_Estudante> getCursoEstudantesByEstudanteId(@PathVariable("id") Long id) {
        return curso_EstudanteService.getCurso_Estudante_ByIdEstudante(id);
    }

    @PostMapping("/adicionar")
    public Curso_Estudante adicionarEstudanteEmCurso(@RequestBody CursoEstudanteId cursoEstudanteId) {
        return curso_EstudanteService.adicionarEstudanteEmCurso(cursoEstudanteId.getCurso(), cursoEstudanteId.getEstudante());
    }
}
