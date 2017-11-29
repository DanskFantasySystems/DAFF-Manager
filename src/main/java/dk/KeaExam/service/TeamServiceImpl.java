package dk.KeaExam.service;

import dk.KeaExam.model.League;
import dk.KeaExam.model.Team;
import dk.KeaExam.model.User;
import dk.KeaExam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserService userService;

    @Override
    public Team findByTeamName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public Team findLoggedInUserTeam(Integer leagueId) {
        //Finder brugeren
        User user = userService.getCurrentUser();
        //Finder brugerens hold i ligaen
        for (Team team : user.getTeams()) {
            if (team.getLeagueid() == leagueId) {
                return team;
            }
        }
        return null;
    }

    @Override
    public List<Team> getAllTeamsInLeague(League league) {
        return league.getTeams();
    }
}
