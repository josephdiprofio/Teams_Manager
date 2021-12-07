package application;

import java.util.ArrayList;

public class Team {
	private String name;
	private String coach;
	private String state;
	private String city;
	private ArrayList<Player> players= new ArrayList<Player>();
	
	public Team(String name, String coach, String state, String city) {
		this.name=name;
		this.coach=coach;
		this.state=state;
		this.city=city;
		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public String getCoach() {
		return coach;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}
}
