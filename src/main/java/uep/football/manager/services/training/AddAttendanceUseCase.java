package uep.football.manager.services.training;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author akazmierczak
 * @date 31.03.2021
 */
public interface AddAttendanceUseCase {

    ModelAndView addAttendance(Long id);

}
