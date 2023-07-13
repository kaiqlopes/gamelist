package com.studying.gamelist.services;

import com.studying.gamelist.dto.GameDTO;
import com.studying.gamelist.dto.GameMinDTO;
import com.studying.gamelist.entities.Game;
import com.studying.gamelist.projections.GameMinProjection;
import com.studying.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> gameList = gameRepository.findAll();
        List<GameMinDTO> result = gameList.stream().map(x -> new GameMinDTO(x)).toList();
        return result;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> gameList = gameRepository.searchByList(listId);
        List<GameMinDTO> result = gameList.stream().map(x -> new GameMinDTO(x)).toList();
        return result;
    }
}
