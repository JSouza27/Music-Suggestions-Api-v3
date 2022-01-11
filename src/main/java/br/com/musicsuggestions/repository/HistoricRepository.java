package br.com.musicsuggestions.repository;

import br.com.musicsuggestions.entity.Historic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.websocket.server.PathParam;
import java.util.List;

public interface HistoricRepository extends CrudRepository<Historic, Long> {

    @Query(value = "SELECT * FROM reproduction_history " +
        "WHERE user_id = :userId "
        , nativeQuery = true)
    List<Historic> findPlayListByUser(@PathParam("userId") Long userId);
}
