package br.com.musicsuggestions.service.interfaces;

import br.com.musicsuggestions.dto.BodyDTO;
import br.com.musicsuggestions.entity.Historic;

import java.util.List;

public interface HistoricServiceInterface {

    Historic save(BodyDTO bodyDTO, String categoryId);

    List<Historic> getPlayListByUser(Long userId);

    List<Historic> getAll();
}
