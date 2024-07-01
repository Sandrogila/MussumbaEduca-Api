package courser.mussumbaeduca.Models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CursoEstudanteId implements Serializable {

    private Long curso;
    private Long estudante;

    public CursoEstudanteId() {}

    public CursoEstudanteId(Long curso, Long estudante) {
        this.curso = curso;
        this.estudante = estudante;
    }

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
        this.curso = curso;
    }

    public Long getEstudante() {
        return estudante;
    }

    public void setEstudante(Long estudante) {
        this.estudante = estudante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoEstudanteId that = (CursoEstudanteId) o;
        return Objects.equals(curso, that.curso) &&
                Objects.equals(estudante, that.estudante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso, estudante);
    }
}
