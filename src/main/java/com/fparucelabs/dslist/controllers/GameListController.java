package com.fparucelabs.dslist.controllers;

import com.fparucelabs.dslist.dto.GameDTO;
import com.fparucelabs.dslist.dto.GameListDTO;
import com.fparucelabs.dslist.dto.GameMinDTO;
import com.fparucelabs.dslist.services.GameListService;
import com.fparucelabs.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;

    private final GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameService = gameService;
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping("/{id}/games")
    public List<GameMinDTO> findAllByGameId(@PathVariable Long id) {
        return gameService.findByList(id);
    }
}
