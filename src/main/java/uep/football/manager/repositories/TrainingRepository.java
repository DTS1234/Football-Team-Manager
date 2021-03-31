package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.Training;

/**
 * @author akazmierczak
 * @date 25.03.2021
 */
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
