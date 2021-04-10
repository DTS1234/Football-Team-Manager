package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.News;
import uep.football.manager.services.news.NewsService;

import java.util.List;

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
    public ModelAndView getAll(){

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newsList", newsService.getAllNews());

        return modelAndView;
    }

}
