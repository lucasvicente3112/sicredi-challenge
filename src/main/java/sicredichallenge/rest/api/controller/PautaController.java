package sicredichallenge.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sicredichallenge.rest.api.model.PautaModel;
import sicredichallenge.rest.api.repository.PautaRepository;

@RestController
public class PautaController {

    @Autowired
    private PautaRepository repository;

    //Retorna informações da pauta informada
    @GetMapping(path = "/api/pauta/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //Cadastra uma nova pauta
    @PostMapping(path = "/api/pauta/cadastrar")
    public PautaModel cadastrar(@RequestBody PautaModel pauta){
        return repository.save(pauta);
    }
}
