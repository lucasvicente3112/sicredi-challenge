package sicredichallenge.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    //Método simples para verificar se a aplicação esta online
    @GetMapping(path = "/api/status")
    public String check(){
        return "Online";
    }
}
