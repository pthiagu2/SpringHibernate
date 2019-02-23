package com.spring.practice.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.practice.pojo.Team;

@Repository
public class TeamDaoImpl implements TeamDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void addTeam(Team team) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(team);
		transaction.commit();
		session.close();
	}

	public void updateTeam(Team team) {
		Team teamToUpdate = getTeam(team.getId());
		teamToUpdate.setName(team.getName());
		teamToUpdate.setRating(team.getRating());
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(teamToUpdate);
		transaction.commit();
		session.close();
	}

	public Team getTeam(int id) {
		Session session = sessionFactory.openSession();
		Team team = (Team) session.get(Team.class, id);
		session.close();
		return team;
	}

	public void deleteTeam(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Team team = getTeam(id);
		if (team != null) {
			session.delete(team);
		}
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Team> getTeams() {
		Session session = sessionFactory.openSession();
		List<Team> teams = session.createQuery("from Team").list();
		session.close();
		return teams;
	}
}
