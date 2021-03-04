package football.repository;

import football.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    @Query("SELECT id FROM Team WHERE name = :name")
    Long findIdOfTeamName(@Param("name") String name);

}
