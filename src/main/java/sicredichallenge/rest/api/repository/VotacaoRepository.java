package sicredichallenge.rest.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sicredichallenge.rest.api.model.VotacaoModel;

public interface VotacaoRepository extends CrudRepository<VotacaoModel, Integer> {

    //Consulta para contar votos por sessão
   @Query(nativeQuery = true, value = "SELECT COUNT(v.voto) FROM votacao v where v.voto = ?1 and v.id_sessao = ?2")
    long countVotos(String voto, Integer sessao);
}
