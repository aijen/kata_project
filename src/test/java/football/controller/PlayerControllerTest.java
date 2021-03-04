package football.controller;

import football.FootballApplication;
import football.dto.PlayerDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class) // JUnit 4
@SpringBootTest( classes = FootballApplication.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_find_all_players() {

        String url = "http://localhost:" + port + "/players";

        ParameterizedTypeReference<List<PlayerDto>> paramType = new ParameterizedTypeReference<List<PlayerDto>>() {};
        ResponseEntity<List<PlayerDto>> playersResponseEntity = restTemplate
                .exchange(url, HttpMethod.GET, null, paramType);

        Assertions.assertThat(playersResponseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);

        List<PlayerDto> players = playersResponseEntity.getBody();

        Assertions.assertThat(players).hasSize(2);

        PlayerDto antoineGriezman = new PlayerDto("Antoine", "Griezmann", "Atlético de Madrid");

        Assertions.assertThat(players).contains(antoineGriezman);

    }

}