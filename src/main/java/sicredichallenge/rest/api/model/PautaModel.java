package sicredichallenge.rest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Pauta")
public class PautaModel {
    @Id
    @Column(name = "id_pauta", nullable = false)
    private Integer idPauta;

    @Column(name = "assunto", nullable = false)
    public String assunto;

    public Integer getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Integer idPauta) {
        this.idPauta = idPauta;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
