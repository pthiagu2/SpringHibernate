package com.spring.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.pojo.Team;
import com.spring.practice.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("teamsList");
		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}
}
