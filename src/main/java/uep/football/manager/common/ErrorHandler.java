package uep.football.manager.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.service.auth.BadCredentialsPassed;
import uep.football.manager.service.auth.LoginDTO;

/**
 * @date 02.06.2021
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({BadCredentialsPassed.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleMealNotFound(Exception exception)
    {
        var loginMv = new ModelAndView("login");
        loginMv.addObject("", new LoginDTO());
        loginMv.addObject("msg", "error");

        return loginMv;
    }

}
