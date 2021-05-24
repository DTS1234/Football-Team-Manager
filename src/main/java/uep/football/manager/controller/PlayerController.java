package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Player;
import uep.football.manager.service.player.PlayerService;
import uep.football.manager.service.training.TrainingService;

/**
 * Controller serves as a communicator between web template and code. Methods use HTTP protocol to pass or fetch data.
 * <p>
 * Look up for templates and find html files with thymeleaf.
 */
@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping(value = "players")
public class PlayerController {

    private final PlayerService playerService;
    private final TrainingService trainingService;

    /**
     * Returns players.html with playerList object.
     */
    @PostMapping("/add")
    public ModelAndView addPlayer(@ModelAttribute Player player) {
        return playerService.addPlayer(player);
    }

    @GetMapping("/add")
    public ModelAndView playerForm() {

        var modelAndView = new ModelAndView("add_player");
        modelAndView.addObject("player", new Player());

        return modelAndView;
    }

    @RequestMapping("/remove/{id}")
    public ModelAndView removePlayer(@PathVariable Long id) {
        return playerService.removePlayer(id);
    }

    @GetMapping
    public ModelAndView playersView() {
        return playerService.allPlayersView();
    }

    @GetMapping("/details/{id}")
    public ModelAndView playerDetails(@PathVariable Long id) {

        var player = playerService.getPLayerById(id);
        var modelAndView = new ModelAndView("player_details");

        modelAndView.addObject("player", player);
        modelAndView.addObject("trainings", trainingService.getAllTrainings());
        return modelAndView;
    }

    @GetMapping("/details/{id}/update")
    public ModelAndView playerDetailsUpdateView(@PathVariable Long id) {

        var player = playerService.getPLayerById(id);
        var modelAndView = new ModelAndView("player_details_update");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @PostMapping("/details/{id}/update")
    public ModelAndView playerDetailsUpdateAction(@PathVariable Long id, @ModelAttribute Player player) {
        playerService.updatePlayerDetails(id, player);
        return playerDetails(id);
    }

    @GetMapping("/details/{id}/update/statistics")
    public ModelAndView playerDetailsUpdateStatisticsView(@PathVariable Long id) {

        var player = playerService.getPLayerById(id);
        var modelAndView = new ModelAndView("player_details_update_stats");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @GetMapping("/details/{id}/update/test")
    public ModelAndView playerDetailsUpdateTestView(@PathVariable Long id) {

        var player = playerService.getPLayerById(id);
        var modelAndView = new ModelAndView("player_details_update_test");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @PostMapping("/details/{id}/update/statistics")
    public ModelAndView playerDetailsUpdateStatisticsAction(@PathVariable Long id, @ModelAttribute Player player) {
        playerService.updatePlayerDetailsStats(id, player);
        return playerDetails(id);
    }

    @PostMapping("/details/{id}/update/test")
    public ModelAndView playerDetailsUpdateTestAction(@PathVariable Long id, @ModelAttribute Player player) {
        playerService.updateTestDetails(id, player);
        return playerDetails(id);
    }

}
