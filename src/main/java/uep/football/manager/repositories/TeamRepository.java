package uep.football.manager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uep.football.manager.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
