package courser.mussumbaeduca.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "curso_estudantes")
@IdClass(CursoEstudanteId.class)
public class Curso_Estudante {

    @Id
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Id
    @ManyToOne
    @JoinColumn(name = "estudante_id", nullable = false)
    private Estudante estudante;

    public Curso_Estudante() {}

    public Curso_Estudante(Curso curso, Estudante estudante) {
        this.curso = curso;
        this.estudante = estudante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
