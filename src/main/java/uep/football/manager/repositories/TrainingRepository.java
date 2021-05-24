package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
