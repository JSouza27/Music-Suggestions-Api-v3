package br.com.musicsuggestions.service;

import br.com.musicsuggestions.entity.Historic;
import br.com.musicsuggestions.repository.HistoricRepository;
import br.com.musicsuggestions.service.interfaces.HistoricServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricService implements HistoricServiceInterface {

    @Autowired
    private HistoricRepository historicRepository;

    @Override
    public Historic save(Historic historic) {
        return historicRepository.save(historic);
    }

    @Override
    public Optional<Historic> getById(Long id) {
        return historicRepository.findById(id);
    }

    @Override
    public List<Historic> getPlayListByUser(Long userId) {
        return historicRepository.findPlayListByUser(userId);
    }

    @Override
    public String delete(Long id) {
        String message = "Playlist deletada com sucesso!";
        historicRepository.deleteById(id);
        return message;
    }
}
