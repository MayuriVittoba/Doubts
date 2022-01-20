package com.to;

import jakarta.persistence.*;

@Entity

@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	@Column(nullable = false, name = "name")
	private String playerName;
	@OneToOne
	private Team team;

	public Team getTeam() {
		return team;
	}

	public Player(String playerName, Team team, int age) {
		super();
		this.playerName = playerName;
		this.team = team;
		this.age = age;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", team=" + team + ", age=" + age + "]";
	}

	private int age;

	public Player(int playerId, String playerName, int age) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.age = age;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
