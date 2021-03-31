package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Player;
import uep.football.manager.services.player.PlayerService;

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

    /**
     * Returns players.html with playerList object.
     */
    @PostMapping("/add")
    public ModelAndView addPlayer(@ModelAttribute Player player) {
        return playerService.addPlayer(player);
    }

    @GetMapping("/add")
    public ModelAndView playerForm() {

        ModelAndView modelAndView = new ModelAndView("add_player");
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

}
