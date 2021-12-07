package application;

public class Player {
	String name;
	String team;
	String height;
	String weight;
	int madeShots=0;
	int missedShots=0;
	int rebounds=0;
	int points=0;
	int assists=0;
	int steals=0;
	int blocks=0;
	int turnovers=0;
	int fouls=0;
	double wins;
	double losses;
	int year;
	
	public Player(String name, String team, String height, String weight) {
		this.name=name;
		this.team=team;
		this.height=height;
		this.weight=weight;
	}
	
	public Player(String name, int year, int madeShots, int missedShots, int rebounds, int points, int assists, int steals, int blocks, int turnovers, double wins, double losses) {
		this.name=name;
		this.year=year;
		this.madeShots=madeShots;
		this.missedShots=missedShots;
		this.rebounds=rebounds;
		this.points=points;
		this.assists=assists;
		this.steals=steals;
		this.blocks=blocks;
		this.turnovers=turnovers;
		this.wins=wins;
		this.losses=losses;
	}
	
	public Player(int madeShots, int missedShots, int rebounds, int points, int assists, int steals, int blocks, int turnovers, double wins, double losses) {
		this.madeShots=madeShots;
		this.missedShots=missedShots;
		this.rebounds=rebounds;
		this.points=points;
		this.assists=assists;
		this.steals=steals;
		this.blocks=blocks;
		this.turnovers=turnovers;
		this.wins=wins;
		this.losses=losses;
	}

	public double getWins() {
		return wins;
	}

	public double getLosses() {
		return losses;
	}

	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getMadeShots() {
		return madeShots;
	}

	public void setMadeShots(int madeShots) {
		this.madeShots = madeShots;
	}

	public int getMissedShots() {
		return missedShots;
	}

	public void incMissedShots() {
		missedShots+=1;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getPoints() {
		return points;
	}

	public void inc1Point() {
		points+=1;
	}
	
	public void inc2Points() {
		points+=2;
	}
	
	public void inc3Points() {
		points+=3;
	}

	public int getAssists() {
		return assists;
	}

	public void incAssists() {
		assists+=1;
	}

	public int getSteals() {
		return steals;
	}

	public void incSteals() {
		steals+=1;
	}

	public int getBlocks() {
		return blocks;
	}

	public void incBlocks() {
		blocks+=1;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void incTurnovers() {
		turnovers+=1;
	}
	
	public void incFouls() {
		fouls+=1;
	}

	public int getFouls() {
		return fouls;
	}
	
	public void incRebounds() {
		rebounds+=1;
	}
	
	public void incMadeShots() {
		madeShots+=1;
	}
	
	public double getFGPercentage() {
		return (madeShots/(madeShots+missedShots))*100;
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
}