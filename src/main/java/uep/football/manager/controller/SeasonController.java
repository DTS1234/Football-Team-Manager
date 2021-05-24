package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Match;
import uep.football.manager.service.season.MatchService;

/**
 * @author akazmierczak
 * @date 11.04.2021
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("season")
public class SeasonController {

    private final MatchService matchService;

    @GetMapping
    public ModelAndView seasonView()
    {
        return matchService.getSeasonView();
    }

    @GetMapping(value = "/add")
    public ModelAndView addMatchView()
    {
        return matchService.getAddMatchForm();
    }

    @PostMapping(value = "/add")
    public ModelAndView addMatchToRoundAction(@ModelAttribute Match match)
    {
        return matchService.addMatch(match);
    }

}
