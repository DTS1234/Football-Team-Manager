package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
