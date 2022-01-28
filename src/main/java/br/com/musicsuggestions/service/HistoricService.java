package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.BodyDTO;
import br.com.musicsuggestions.entity.Historic;
import br.com.musicsuggestions.repository.HistoricRepository;
import br.com.musicsuggestions.service.interfaces.HistoricServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoricService implements HistoricServiceInterface {

    @Autowired
    private HistoricRepository historicRepository;

    @Override
    public Historic save(BodyDTO body, String categoryId) {
        Historic historic = new Historic();
        historic.setCreatedAt(LocalDateTime.now());
        historic.setPlaylist(categoryId);
        historic.setUserId(body.getUserId());

        return historicRepository.save(historic);
    }

    @Override
    public List<Historic> getPlayListByUser(Long userId) {
        return historicRepository.findByUserId(userId);
    }

    @Override
    public List<Historic> getAll() {
        return historicRepository.findAll();
    }
}
