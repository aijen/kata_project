package football.controller;

import football.FootballApplication;
import football.dto.PlayerDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//@RunWith(SpringRunner.class) // JUnit 4
@SpringBootTest( classes = FootballApplication.class
               , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT //pour ne pas avoir des collisions sur les port
)
@Sql(value = "/script-player-controller.sql")
public class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    /*
    @Sql(value = "/script-player-controller.sql"
            , config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
    */
    public void should_find_all_players() {

        String url = "http://localhost:" + port + "/players";

        ParameterizedTypeReference<List<PlayerDto>> paramType = new ParameterizedTypeReference<List<PlayerDto>>() {};
        ResponseEntity<List<PlayerDto>> playersResponseEntity = restTemplate
                .exchange(url, HttpMethod.GET, null, paramType);

        assertThat(playersResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<PlayerDto> players = playersResponseEntity.getBody();

        assertThat(players).hasSize(2);

        PlayerDto antoineGriezman = new PlayerDto("Antoine", "Griezmann", "Atlético de Madrid");

        assertThat(players).contains(antoineGriezman);

    }

}