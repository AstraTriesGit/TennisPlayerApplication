package com.example.demo;

import jakarta.transaction.Transactional;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Ref;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRestRepo repo;

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Player getPlayerById(int id) {
        Optional<Player> temp = repo.findById(id);
        Player p;

        if (temp.isPresent()) {
            p = temp.get();
        } else {
            throw new RuntimeException("Player with id " + id + " not found");
        }
        return p;
    }

    public Player addPlayer(Player p) {
        return repo.save(p);
    }

    public Player updatePlayer(int id, Player player) {
        Player p = repo.getOne(id);
        p.setNationality(player.getNationality());
        p.setName(player.getName());
        p.setTitles(player.getTitles());
        p.setBirthDate(player.getBirthDate());

        return repo.save(p);
    }

    public Player patch(int id, Map<String, Object> playerPatch) {
        Optional<Player> player = repo.findById(id);
        Player p;
        if (player.isPresent()) {
            playerPatch.forEach( (key, value) -> {
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
        }
        return repo.save(player.get());
    }

    @Transactional
    public void updateTitles(int id, int titles) {
        repo.updateTitles(id, titles);
    }

    public String deletePlayer(int id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            return "Player with id not found " + id;
        }
        return "Deleted player with id " + id;
    }
}
