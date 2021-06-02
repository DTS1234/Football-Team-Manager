package uep.football.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uep.football.manager.domain.Club;
import uep.football.manager.domain.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    public List<News> findByClub(Club club);

}
