package uep.football.manager.service.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uep.football.manager.domain.Coach;
import uep.football.manager.domain.Manager;
import uep.football.manager.domain.Player;
import uep.football.manager.repositories.CoachRepository;
import uep.football.manager.repositories.ManagerRepository;
import uep.football.manager.repositories.PlayerRepository;
import uep.football.manager.service.coach.CoachNotFoundException;
import uep.football.manager.service.manager.ManagerNotFoundException;
import uep.football.manager.service.player.PlayerNotFoundException;

/**
 * @date 02.06.2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final LoginState loginState;
    private final PlayerRepository playerRepository;
    private final CoachRepository coachRepository;
    private final ManagerRepository managerRepository;

    public Player getCurrentLoggedInUser()
    {
        return playerRepository.findById(loginState.id).orElseThrow(PlayerNotFoundException::new);
    }

    public void logout()
    {
        loginState.loggedIn = false;
        loginState.isManger = false;
        loginState.isCoach = false;
    }

    public void checkLogin(LoginDTO loginDTO) {

        String username = loginDTO.getUsername();
        if (playerRepository.existsByUsername(username)) {
            log.info("trying to authenticate player with username " + username + ".");
            var player = playerRepository.findByUsername(username).orElseThrow(PlayerNotFoundException::new);
            boolean credentialsCorrect = checkCredentials(loginDTO, player);
            loginPlayer(player, credentialsCorrect);
        }

        if (coachRepository.existsByUsername(username)) {
            log.info("trying to authenticate coach with username " + username + ".");
            var coach = coachRepository.findByUsername(username).orElseThrow(CoachNotFoundException::new);
            boolean credentialsCorrect = checkCredentials(loginDTO, coach);
            loginCoach(coach, credentialsCorrect);
        }

        if (managerRepository.existsByUsername(username)) {
            log.info("trying to authenticate manager with id " + username + ".");
            var manager = managerRepository.findByUsername(username).orElseThrow(ManagerNotFoundException::new);
            boolean credentialsCorrect = checkCredentials(loginDTO, manager);
            loginManager(manager, credentialsCorrect);
        }

    }

    private void loginPlayer(Player player, boolean credentialsCorrect) {
        if (credentialsCorrect) {
            loginState.loggedIn = true;
            loginState.id = player.getPlayerId();
            loginState.isCoach = false;
            loginState.isManger = false;
        } else {
            throw new BadCredentialsPassed("Failed to login for player.");
        }
    }

    private void loginCoach(Coach coach, boolean credentialsCorrect) {
        if (credentialsCorrect) {
            loginState.loggedIn = true;
            loginState.id = coach.getCoachId();
            loginState.isCoach = true;
            loginState.isManger = false;
        } else {
            throw new BadCredentialsPassed("Failed to login for coach.");
        }
    }

    private void loginManager(Manager manager, boolean credentialsCorrect) {
        if (credentialsCorrect) {
            loginState.loggedIn = true;
            loginState.id = manager.getManagerId();
            loginState.isManger = true;
            loginState.isCoach = false;
        } else {
            throw new BadCredentialsPassed("Failed to login for manager.");
        }
    }


    private boolean checkCredentials(LoginDTO loginDTO, Player player) {

        String clubName = player.getClub().getName();
        String username = player.getUsername();
        String password = player.getPassword();

        return loginDTO.getPassword().equals(password) && loginDTO.getUsername().equals(username) && loginDTO.getClubName().equals(clubName);
    }

    private boolean checkCredentials(LoginDTO loginDTO, Coach coach) {

        String clubName = coach.getClub().getName();
        String username = coach.getUsername();
        String password = coach.getPassword();

        return loginDTO.getPassword().equals(password) && loginDTO.getUsername().equals(username) && loginDTO.getClubName().equals(clubName);
    }

    private boolean checkCredentials(LoginDTO loginDTO, Manager manager) {

        String clubName = manager.getClub().getName();
        String username = manager.getUsername();
        String password = manager.getPassword();

        return loginDTO.getPassword().equals(password) && loginDTO.getUsername().equals(username) && loginDTO.getClubName().equals(clubName);
    }

}
