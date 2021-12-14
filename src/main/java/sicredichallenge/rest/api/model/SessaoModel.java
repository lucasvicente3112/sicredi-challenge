package sicredichallenge.rest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "Sessao")
public class SessaoModel {

    @Id
    @Column(name = "id_sessao", nullable = false)
    private Integer idSessao;

    @Column(name = "id_pauta", nullable = false)
    public Integer idPauta;

    @Column(name = "duracao", nullable = true)
    public Integer duracao;

    @Column(name = "inicio", nullable = true)
    @JsonIgnore
    public LocalDateTime incio;

    @Column(name = "fim", nullable = true)
    @JsonIgnore
    public LocalDateTime fim;

    public Integer getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Integer idSessao) {
        this.idSessao = idSessao;
    }

    public Integer getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Integer idPauta) {
        this.idPauta = idPauta;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public LocalDateTime getIncio() {
        return incio;
    }

    public void setIncio(LocalDateTime incio) {
        this.incio = incio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}