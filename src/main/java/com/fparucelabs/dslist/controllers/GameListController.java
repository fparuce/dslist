package com.fparucelabs.dslist.controllers;

import com.fparucelabs.dslist.dto.GameListDTO;
import com.fparucelabs.dslist.services.GameListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
