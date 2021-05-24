package uep.football.manager.service.season;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.common.ResultEnum;
import uep.football.manager.domain.Match;
import uep.football.manager.domain.Team;
import uep.football.manager.repositories.MatchRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final TeamService teamService;

    public ModelAndView getSeasonView() {
        List<Match> allGames = matchRepository.findAll();

        var modelAndView = new ModelAndView("season");
        modelAndView.addObject("matches", allGames);
        modelAndView.addObject("teams", getTeamTableForRound());

        return modelAndView;
    }

    private List<Team> getTeamTableForRound() {
        List<Team> teamList = teamService.getAllTeams().stream().sorted(Comparator.comparing(Team::getPts)).collect(Collectors.toList());
        Collections.reverse(teamList);
        return teamList;
    }

    public ModelAndView getAddMatchForm() {
        var modelAndView = new ModelAndView("add_match");
        modelAndView.addObject("match", new Match());
        return modelAndView;
    }

    public ModelAndView addMatch(Match match) {


        if (match.getGoalsLost() > match.getGoalsScored()) {
            match.setResult(ResultEnum.DEFEAT);
        } else if (match.getGoalsLost() < match.getGoalsScored()) {
            match.setResult(ResultEnum.WIN);
        } else {
            match.setResult(ResultEnum.DRAW);
        }
        matchRepository.save(match);
        return getSeasonView();
    }
}
