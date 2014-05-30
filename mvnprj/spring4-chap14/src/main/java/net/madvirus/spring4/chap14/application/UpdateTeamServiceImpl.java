package net.madvirus.spring4.chap14.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import net.madvirus.spring4.chap14.domain.Team;
import net.madvirus.spring4.chap14.domain.TeamRepository;

public class UpdateTeamServiceImpl implements UpdateTeamService {

	@Autowired
	private TeamRepository teamRepository;

	public void setTeamRepository(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Transactional
	@Override
	public void udpateName(Long teamId, String newName) {
		Team team = teamRepository.findOne(teamId);
		if (team == null)
			throw new TeamNotFoundException("No Team for ID[" + teamId + "]");
		System.out.println("변경 전: " + team.getName());
		int updated = teamRepository.updateName(teamId, newName);
		System.out.println("변경 개수: " + updated);
		System.out.println("변경 후 :" + team.getName());
	}

}
