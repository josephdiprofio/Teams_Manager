package application;



public class TeamTotals {
	int year;
	double wins;
	double losses;
	int rebounds;
	int points;
	double made_shots;
	int missed_shots;
	int assists;
	int steals;
	int blocks;
	int turnovers;
	int oppPoints;
	
	public TeamTotals(int year, double wins, double losses, int rebounds, int points, double made_shots, int missed_shots, int assists, int steals, int blocks, int turnovers, int oppPoints) {
		this.year=year;
		this.wins=wins;
		this.losses=losses;
		this.rebounds=rebounds;
		this.points=points;
		this.made_shots=made_shots;
		this.missed_shots=missed_shots;
		this.assists=assists;
		this.steals=steals;
		this.blocks=blocks;
		this.turnovers=turnovers;
		this.oppPoints=oppPoints;
	}
	
	public TeamTotals(int wins, int losses, int rebounds, int points, int made_shots, int missed_shots, int assists, int steals, int blocks, int turnovers, int oppPoints) {
		this.wins=wins;
		this.losses=losses;
		this.rebounds=rebounds;
		this.points=points;
		this.made_shots=made_shots;
		this.missed_shots=missed_shots;
		this.assists=assists;
		this.steals=steals;
		this.blocks=blocks;
		this.turnovers=turnovers;
		this.oppPoints=oppPoints;
	}
	

	public int getYear() {
		return year;
	}

	public double getWins() {
		return wins;
	}

	public double getLosses() {
		return losses;
	}

	public int getRebounds() {
		return rebounds;
	}

	public int getPoints() {
		return points;
	}

	public double getMade_shots() {
		return made_shots;
	}

	public int getMissed_shots() {
		return missed_shots;
	}

	public int getAssists() {
		return assists;
	}

	public int getSteals() {
		return steals;
	}

	public int getBlocks() {
		return blocks;
	}

	public int getTurnovers() {
		return turnovers;
	}
	
	public double getFGPercentage() {
		return (made_shots/(made_shots+missed_shots))*100;
	}
	
	public double getPPG() {
		return points/(wins+losses);
	}
	
	public double getAPG() {
		return assists/(wins+losses);
	}
	
	public double getRPG() {
		return rebounds/(wins+losses);
	}
	
	public double getBPG() {
		return blocks/(wins+losses);
	}
	
	public double getSPG() {
		return steals/(wins+losses);
	}
	
	public double getTOPG() {
		return turnovers/(wins+losses);
	}
	
	public double getPAPG() {
		return oppPoints/(wins+losses);
	}
	
	public double getMOV() {
		return (points-oppPoints)/(wins+losses);
	}
}
