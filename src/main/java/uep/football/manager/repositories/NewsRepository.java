package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.News;

/**
 * @author akazmierczak
 * @date 10.04.2021
 */
public interface NewsRepository extends JpaRepository<News, Long> {
}
