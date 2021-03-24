package uep.football.manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Player;
import uep.football.manager.repositories.PlayerRepository;

import java.util.List;
import java.util.Optional;

/**
 * Controller serves as a communicator between web template and code. Methods use HTTP protocol to pass or fetch data.
 *
 * Look up for templates and find html files with thymeleaf.
 *
 */
@Controller
@Slf4j
@RequestMapping(value = "players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * This method will add player to data base, and then returns html called 'players.html'.
     */
    @PostMapping("/add")
    public ModelAndView addPlayer(@ModelAttribute Player player, Model model) {

        model.addAttribute(player);
        playerRepository.save(player);
        List<Player> playerList = playerRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", playerList);

        return modelAndView;
    }

    @GetMapping("/add")
    public String playerForm(Model model) {

        model.addAttribute("player", new Player());

        return "add_player";
    }

    @RequestMapping("/remove/{id}")
    public ModelAndView removePlayer(@PathVariable Long id) {

        Optional<Player> playerOptional = playerRepository.findById(id);

        if (playerOptional.isPresent())
        {
            playerRepository.delete(playerOptional.get());
        }

        log.info("No player with id "+ id);

        List<Player> playerList = playerRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", playerList);

        return modelAndView;
    }

    @GetMapping
    public ModelAndView playersView()
    {
        return new ModelAndView("players");
    }

}
