package uep.football.manager.services.news;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uep.football.manager.domain.News;
import uep.football.manager.repositories.NewsRepository;

import java.util.List;

/**
 * @author akazmierczak
 * @date 10.04.2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {

    private final NewsRepository newsRepository;

    public List<News> getAllNews()
    {
        return newsRepository.findAll();
    }

}
