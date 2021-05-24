package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
