package com.studying.gamelist.services;

import com.studying.gamelist.dto.GameListDTO;
import com.studying.gamelist.entities.GameList;
import com.studying.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> list = gameListRepository.findAll();
        List<GameListDTO> result = list.stream().map(x -> new GameListDTO(x)).toList();
        return result;
    }

}
