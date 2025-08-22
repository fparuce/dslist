package com.fparucelabs.dslist.services;

import com.fparucelabs.dslist.dto.GameDTO;
import com.fparucelabs.dslist.dto.GameMinDTO;
import com.fparucelabs.dslist.exceptions.DomainException;
import com.fparucelabs.dslist.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return gameRepository.findById(id)
                .map(GameDTO::new)
                .orElseThrow(() -> new DomainException("Game not found with id: " + id, HttpStatus.NOT_FOUND.value()));
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.searchByList(listId)
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
