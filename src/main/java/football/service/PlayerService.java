package football.service;

import football.dto.PlayerDto;
import football.entity.Player;
import football.entity.Team;
import football.repository.PlayerRepository;
import football.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    private TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional(readOnly = true)
    public List<PlayerDto> findPlayersWithTeamName() {
        List<Player> players = playerRepository.findAll();
        return  players
               .stream()
               .map(player -> new PlayerDto(
                                    player.getFirstName()
                                  , player.getLastName()
                                  , player.getTeam().getName()
                              )
                    )
               .collect(toList());
    }

    public void create(PlayerDto playerDto) {

        Team team = new Team();
        String teamName = playerDto.getTeam();
        team.setId(teamRepository.findIdOfTeamName(teamName));

        Player player = new Player();
        player.setFirstName(playerDto.getFirstName());
        player.setLastName(playerDto.getLastName());
        player.setTeam(team);

        playerRepository.save(player);

    }

}
