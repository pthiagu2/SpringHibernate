package com.spring.practice.dao;

import java.util.List;
import com.spring.practice.pojo.Team;

public interface TeamDAO {
	public void addTeam(Team team);

	public void updateTeam(Team team);

	public Team getTeam(int id);

	public void deleteTeam(int id);

	public List<Team> getTeams();
}
