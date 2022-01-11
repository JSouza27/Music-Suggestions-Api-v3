package br.com.musicsuggestions.service.interfaces;

import br.com.musicsuggestions.entity.Historic;

import java.util.List;
import java.util.Optional;

public interface HistoricServiceInterface {

    Historic save(Historic historic);

    Optional<Historic> getById(Long id);

    List<Historic> getPlayListByUser(Long user);

    String delete(Long id);
}
