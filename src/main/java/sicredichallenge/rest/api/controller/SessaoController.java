package sicredichallenge.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sicredichallenge.rest.api.model.SessaoModel;
import sicredichallenge.rest.api.repository.SessaoRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
public class SessaoController {

    @Autowired
    private SessaoRepository repository;

    //Retorna informações da sessão informada
    @GetMapping(path = "/api/sessao/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //Cria uma nova sessão configurando o tempo em que a mesma fica disponível para receber votos
    @PostMapping(path = "/api/sessao/cadastrar")
    public SessaoModel cadastrar(@RequestBody SessaoModel sessao){
        //Inicia sessão durante 1 minuto por padrão
        long tempoSessao = 1L;
        tempoSessao = sessao.getDuracao().longValue();
        LocalDateTime dataInicio = LocalDateTime.now();
        LocalDateTime dataFim = LocalDateTime.now().plus(Duration.of(tempoSessao, ChronoUnit.MINUTES));

        sessao.setIncio(dataInicio);
        sessao.setFim(dataFim);
        return repository.save(sessao);
    }
}
