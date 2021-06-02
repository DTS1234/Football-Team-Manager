package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.Manager;

import java.util.Optional;

/**
 * @date 02.06.2021
 */
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    boolean existsByUsername(String username);
    Optional<Manager> findByUsername(String username);

}
