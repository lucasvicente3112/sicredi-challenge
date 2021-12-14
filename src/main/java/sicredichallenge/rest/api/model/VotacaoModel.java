package sicredichallenge.rest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Votacao")
public class VotacaoModel {
    @Id
    @Column(name = "id_votacao", nullable = false)
    private Integer idVotacao;

    @Column(name = "id_sessao", nullable = false)
    public Integer idSessao;

    @Column(name = "voto", nullable = false)
    public String voto;

    public Integer getIdVotacao() {
        return idVotacao;
    }

    public void setIdVotacao(Integer idVotacao) {
        this.idVotacao = idVotacao;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
