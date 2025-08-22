package com.fparucelabs.dslist.services;

import com.fparucelabs.dslist.dto.GameListDTO;
import com.fparucelabs.dslist.repositories.GameListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {
    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    public List<GameListDTO> findAll() {
        return gameListRepository.findAll()
                .stream()
                .map(GameListDTO::new)
                .toList();
    }
}
