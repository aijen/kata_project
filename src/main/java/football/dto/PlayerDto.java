package football.dto;

import java.io.Serializable;

public class PlayerDto implements Serializable {

    private final String firstName;

    private final String lastName;

    private final String team;

    public PlayerDto(String firstName, String lastName, String team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDto playerDto = (PlayerDto) o;
        if (!firstName.equals(playerDto.firstName)) return false;
        if (!lastName.equals(playerDto.lastName)) return false;
        return team.equals(playerDto.team);
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
