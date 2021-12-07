package application;

public class BoxScore {
	String userTeam;
	String oppTeam;
	int userScore;
	int oppScore;
	int year;
	
	public BoxScore(String userTeam, String oppTeam, int userScore, int oppScore, int year) {
		this.userTeam=userTeam;
		this.oppTeam=oppTeam;
		this.userScore=userScore;
		this.oppScore=oppScore;
		this.year=year;
	}

	public String getUserTeam() {
		return userTeam;
	}

	public String getOppTeam() {
		return oppTeam;
	}

	public int getUserScore() {
		return userScore;
	}

	public int getOppScore() {
		return oppScore;
	}

	public int getYear() {
		return year;
	}
}
