package dk.KeaExam.service;

import dk.KeaExam.model.League;
import dk.KeaExam.model.User;

import java.util.List;

public interface LeagueService {
    void saveLeague(League league);

    List<League> findAllLeagues();

    League getOneLeague(Integer LeagueId);

    List<League> findAllAvailableLeagues();

}