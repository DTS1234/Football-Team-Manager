package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.service.auth.AuthService;
import uep.football.manager.service.auth.LoginDTO;
import uep.football.manager.service.news.NewsService;

/**
 * @date 02.06.2021
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;
    private final NewsService newsService;

    @GetMapping("/login")
    public ModelAndView loginView() {

        var loginMv = new ModelAndView("login");
        loginMv.addObject("", new LoginDTO());

        return loginMv;
    }

    @PostMapping("/login")
    public ModelAndView loginAction(@ModelAttribute LoginDTO loginDTO) {

        authService.checkLogin(loginDTO);

        var loginMv = new ModelAndView("redirect:/");
        loginMv.addObject("newsList", newsService.getAllNews());

        return loginMv;
    }

    @GetMapping("/logout")
    public ModelAndView logout(@ModelAttribute LoginDTO loginDTO) {

        authService.logout();

        var loginMv = new ModelAndView("login");
        loginMv.addObject("", new LoginDTO());

        return loginMv;
    }

}
