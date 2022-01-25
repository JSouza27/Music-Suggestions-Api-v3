package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.BodyDTO;
import br.com.musicsuggestions.entity.Historic;
import br.com.musicsuggestions.entity.User;
import br.com.musicsuggestions.repository.HistoricRepository;
import br.com.musicsuggestions.service.interfaces.HistoricServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricService implements HistoricServiceInterface {

    @Autowired
    private HistoricRepository historicRepository;

    @Autowired UserService userService;

    @Override
    public Historic save(BodyDTO body, String categoryId) {
        User user = userService.getById(body.getUserId()).get();

        Historic historic = new Historic();
        historic.setCreatedAt(LocalDateTime.now());
        historic.setPlayList(categoryId);
        historic.setUser(user);

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
