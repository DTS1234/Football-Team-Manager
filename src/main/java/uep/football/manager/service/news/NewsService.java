package uep.football.manager.service.news;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uep.football.manager.domain.News;
import uep.football.manager.repositories.NewsRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @date 10.04.2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {

    private final NewsRepository newsRepository;

    public List<News> getAllNews()
    {
        List<News> all = newsRepository.findAll();

        List<News> sorted = all.stream().sorted(Comparator.comparing(News::getDateTime)).collect(Collectors.toList());
        Collections.reverse(sorted); // reversing to get latest on top

        return sorted;
    }

    public News addNewPost(News news)
    {
        if (news.getContent().trim().equals(""))
        {
            throw new NewsDataException("Content for post cannot be empty");
        }

        if (news.getSubject().trim().equals(""))
        {
            throw new NewsDataException("Subject for post cannot be empty");
        }

        news.setDateTime(LocalDateTime.now());
        var saved = newsRepository.save(news);

        log.info("news saved properly");

        return saved;
    }

}
