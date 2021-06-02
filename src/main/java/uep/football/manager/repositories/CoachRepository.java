package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.Coach;
import uep.football.manager.domain.Player;

import java.util.Optional;

/**
 * @date 02.06.2021
 */
public interface CoachRepository extends JpaRepository<Coach, Long> {
    boolean existsByUsername(String username);
    Optional<Coach> findByUsername(String username);

}
