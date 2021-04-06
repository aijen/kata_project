package football.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import football.FootballApplication;
import football.dto.PlayerDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = FootballApplication.class)
@AutoConfigureMockMvc
public class PlayerControllerWithMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_find_all_players() throws Exception {

        ResultActions result = mockMvc.perform(get("/players"));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("[0].firstName", equalTo("Paul")));
        result.andExpect(jsonPath("[0].lastName", equalTo("Pogba")));
        result.andExpect(jsonPath("[0].team", equalTo("Manchester United")));


        MvcResult mvcResult = result.andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        System.out.println("json = " + json);

        List<PlayerDto> players = objectMapper.readValue(json
                                                       , new TypeReference<List<PlayerDto>>() {});

        assertThat(players.get(0).getFirstName()).isEqualTo("Paul");
        assertThat(players.get(0).getLastName()).isEqualTo("Pogba");
        assertThat(players.get(0).getTeam()).isEqualTo("Manchester United");

        PlayerDto expectedPlayer = new PlayerDto("Paul", "Pogba", "Manchester United");
        assertThat(players.get(0)).isEqualTo(expectedPlayer);


    }

}
