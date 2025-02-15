package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping; //Indica que um metodo dentro do controlador sera chamado quando uma requisição HTTPB POST for feita
import org.springframework.web.bind.annotation.RequestBody; // Informa ao Spring que o corpo da requisição HTTP(jSON, XML) deve ser convertido e passado como argumento no metodo
import org.springframework.web.bind.annotation.RequestMapping; //Define a o URL base do controlador
import org.springframework.web.bind.annotation.RestController; // Indica que a classe é responsavel por lidar com requisições HTTP e retorna respostas (jSON, XML)

@RestController //Indica classe controller
@RequestMapping("medicos") //Indica a URL base

public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastraMedico(@RequestBody DadosCadastroMedico dados) {   /*O parâmetro @RequestBody DadosCadastroMedico dados indica que
                                                                               o corpo da requisição será passado
                                                                               como uma classe, para termos os dados detalhados de cada medico*/
        repository.save(new Medico(dados));
    }
}
