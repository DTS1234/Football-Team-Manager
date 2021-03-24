package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uep.football.manager.domain.Player;

/**
 *
 * Here we have only interface Spring Data will create methods for us like, save, findById etc.
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
