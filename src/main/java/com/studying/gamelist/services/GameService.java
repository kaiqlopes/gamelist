package com.studying.gamelist.services;

import com.studying.gamelist.dto.GameMinDTO;
import com.studying.gamelist.entities.Game;
import com.studying.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> gameList = gameRepository.findAll();
        List<GameMinDTO> result = gameList.stream().map(x -> new GameMinDTO(x)).toList();
        return result;
    }

}
