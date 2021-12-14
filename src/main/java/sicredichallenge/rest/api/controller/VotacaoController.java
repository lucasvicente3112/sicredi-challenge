package sicredichallenge.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sicredichallenge.rest.api.model.SessaoModel;
import sicredichallenge.rest.api.model.VotacaoModel;
import sicredichallenge.rest.api.repository.SessaoRepository;
import sicredichallenge.rest.api.repository.VotacaoRepository;

import java.time.LocalDateTime;

@RestController
public class VotacaoController {

    @Autowired
    private VotacaoRepository repository;

    @Autowired
    private SessaoRepository repositorySessao;

    //Retorna a quantidade de votos que uma determinada sessão recebeu
    @GetMapping(path = "/api/votacao/resultado/{sessao}")
    public String resultado(@PathVariable("sessao") Integer sessao){
        long votosSim = repository.countVotos("Sim", sessao);
        long votosNao = repository.countVotos("Não", sessao);
        return "Resultado:"+ "\n" +
                "Votos sim: " + votosSim + "\n" +
                "Votos não: " + votosNao;
    }

    //Verifica utilizando a data/horario atual se o período para votação esta aberto, caso esteja, cadastra o voto, se não informa que a sessão já encerrou
    @PostMapping(path = "/api/votacao/cadastrar")
    public String cadastrar(@RequestBody VotacaoModel votacao){

        LocalDateTime dataIni = repositorySessao.findById(votacao.idSessao)
                .map(SessaoModel::getIncio)
                .get();
        LocalDateTime dataFim = repositorySessao.findById(votacao.idSessao)
                .map(SessaoModel::getFim)
                .get();
        LocalDateTime dataAtual = LocalDateTime.now();

        if(dataIni.isBefore(dataAtual) && dataFim.isAfter(dataAtual)) {
            repository.save(votacao);
            return "Voto registrado";
        }else{
            return "Sessão já encerrou!";
        }
    }
}
