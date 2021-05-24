package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Player;
import uep.football.manager.service.manager.ManagerService;
import uep.football.manager.service.player.PlayerService;

/**
 * @date 23.05.2021
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ManagerController {

    private final PlayerService playerService;
    private final ManagerService managerService;

    @GetMapping("/manager")
    public ModelAndView managerView() {
        var managerView = new ModelAndView("manager");
        managerView.addObject("players", playerService.getAllPLayers());
        return managerView;
    }

    @GetMapping("/manager/{playerId}/edit")
    public ModelAndView editView(@PathVariable Long playerId)
    {
        var modelAndView = new ModelAndView("manager_edit");
        modelAndView.addObject("player", playerService.getPLayerById(playerId));
        return modelAndView;
    }

    @PostMapping("/manager/{playerId}/edit")
    public ModelAndView editAction(@PathVariable Long playerId, @ModelAttribute Player player)
    {
        managerService.setPlayerInjured(playerId, player.isInjured());
        managerService.setPlayerSuspended(playerId, player.isSuspended());

        return managerView();
    }

}
