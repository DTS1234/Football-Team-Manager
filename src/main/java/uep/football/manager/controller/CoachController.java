package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.controller.dto.PositionDTO;
import uep.football.manager.domain.Player;
import uep.football.manager.service.coach.CoachService;
import uep.football.manager.service.player.PlayerService;

/**
 * @date 23.05.2021
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class CoachController {

    private final PlayerService playerService;
    private final CoachService coachService;

    @GetMapping("/coach")
    public ModelAndView coachView() {
        var coachView = new ModelAndView("coach");
        coachView.addObject("players", playerService.getAllPLayers());
        coachView.addObject("position", new PositionDTO());
        coachView.addObject("squad", coachService.getSquad());

        return coachView;
    }

    @GetMapping("/coach/goals")
    public ModelAndView coachViewGoals() {
        var coachView = new ModelAndView("coach");
        coachView.addObject("players", playerService.getAllPlayersByGoals());
        coachView.addObject("position", new PositionDTO());
        coachView.addObject("squad", coachService.getSquad());

        return coachView;
    }

    @GetMapping("/coach/assists")
    public ModelAndView coachViewAssists() {
        var coachView = new ModelAndView("coach");
        coachView.addObject("players", playerService.getAllPlayersByAssists());
        coachView.addObject("position", new PositionDTO());
        coachView.addObject("squad", coachService.getSquad());

        return coachView;
    }

    @GetMapping("/coach/yellow")
    public ModelAndView coachViewYellow() {
        var coachView = new ModelAndView("coach");
        coachView.addObject("players", playerService.getAllPlayersByYellow());
        coachView.addObject("position", new PositionDTO());
        coachView.addObject("squad", coachService.getSquad());

        return coachView;
    }

    @GetMapping("/coach/red")
    public ModelAndView coachViewRed() {
        var coachView = new ModelAndView("coach");
        coachView.addObject("players", playerService.getAllPlayersByReds());
        coachView.addObject("position", new PositionDTO());
        coachView.addObject("squad", coachService.getSquad());
        return coachView;
    }

    @GetMapping("/coach/attendance")
    public ModelAndView coachViewAttendance()
    {
        var coachView = new ModelAndView("coach");
        coachView.addObject("players", playerService.getAllPLayersByAttendance());
        coachView.addObject("position", new PositionDTO());
        coachView.addObject("squad", coachService.getSquad());
        return coachView;
    }

    @PostMapping("/coach/{playerId}")
    public ModelAndView setPosition(@ModelAttribute PositionDTO position, @PathVariable Long playerId){
        log.info(position.getPosition());

        var benchedPlayer = coachService.getPlayerByPosition(position.getPosition());

        if (benchedPlayer != null){
            benchedPlayer.setPosition("bench");
        }

        coachService.changePlayerPosition(playerId, position.getPosition());
        coachView().addObject("squad", coachService.getSquad());

        return coachView();
    }



}
