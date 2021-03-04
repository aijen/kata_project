package football.controller;

import football.dto.PlayerDto;
import football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<PlayerDto> findAll() {
        return playerService.findPlayersWithTeamName();
    }

    @PostMapping("/players")
    public void create(@RequestBody PlayerDto playerDto) {
        playerService.create(playerDto);
    }

}
