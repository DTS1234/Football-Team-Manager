package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.News;
import uep.football.manager.service.news.NewsService;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author akazmierczak
 * @date 10.04.2021
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping()
public class NewsController {

    private final NewsService newsService;

    @RequestMapping
    public ModelAndView getAll() {

        var modelAndView = new ModelAndView("index");
        modelAndView.addObject("newsList", newsService.getAllNews());
        return modelAndView;
    }

    @GetMapping("/add/news")
    public ModelAndView addPostView() {
        var modelAndView = new ModelAndView("add_news");
        modelAndView.addObject("news", new News());

        return modelAndView;
    }

    @PostMapping("/add/news")
    public ModelAndView addPostView(@ModelAttribute News news) {
        newsService.addNewPost(news);
        return getAll();
    }


}
