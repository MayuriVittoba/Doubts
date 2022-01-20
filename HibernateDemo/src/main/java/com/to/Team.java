package com.to;

import jakarta.persistence.*;

@Entity

@Table
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	private String teamName;

	public int getTeamId() {
		return teamId;
	}

	public Team(String teamName) {
		super();
		this.teamName = teamName;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
