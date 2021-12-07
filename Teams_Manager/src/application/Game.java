package application;

public class Game {
	Team userTeam;
	String oppTeam;
	int userScore=0;
	int oppScore=0;
	int userTFouls=0;
	int oppTFouls=0;
	int userTimeouts=0;
	int oppTimeouts=0;
	int year;
	int userMadeShots=0;
	int userMissedShots=0;
	int oppMadeShots=0;
	int oppMissedShots=0;
	int userTurnovers=0;
	int oppTurnovers=0;
	int userAssists=0;
	int oppAssists=0;
	int userSteals=0;
	int oppSteals=0;
	int userBlocks=0;
	int oppBlocks=0;
	int userRebounds=0;
	int oppRebounds=0;
	int userWin=0;
	int userLoss=0;
	public Game(Team userTeam, String oppTeam, int year) {
		this.userTeam=userTeam;
		this.oppTeam=oppTeam;
		this.year=year;
	}

	public String getOppTeam() {
		return oppTeam;
	}

	public Team getUserTeam() {
		return userTeam;
	}
	
	public void inc1UserScore() {
		userScore+=1;
	}
	
	public void inc2UserScore() {
		userScore+=2;
	}
	
	public void inc3UserScore() {
		userScore+=3;
	}

	public int getUserScore() {
		return userScore;
	}
	
	public void incUserFouls() {
		userTFouls+=1;
	}

	public int getUserTFouls() {
		return userTFouls;
	}
	
	public void incUserTurnover() {
		userTurnovers+=1;
	}
	
	public void incUserBlocks() {
		userBlocks+=1;
	}
	
	public void incUserAssists() {
		userAssists+=1;
	}
	
	public void incUserSteals() {
		userSteals+=1;
	}
	
	public void incUserMissedShots() {
		userMissedShots+=1;
	}
	
	public void inc1OppScore() {
		oppScore+=1;
	}
	
	public void inc2OppScore() {
		oppScore+=2;
	}
	
	public void inc3OppScore() {
		oppScore+=3;
	}

	public int getOppScore() {
		return oppScore;
	}
	
	public void incOppFouls() {
		oppTFouls+=1;
	}

	public int getOppTFouls() {
		return oppTFouls;
	}
	
	public void incOppTurnovers() {
		oppTurnovers+=1;
	}
	
	public void incOppBlocks() {
		oppBlocks+=1;
	}
	
	public void incOppAssists() {
		oppAssists+=1;
	}
	
	public void incOppSteals() {
		oppSteals+=1;
	}
	
	public void incOppMissedShots() {
		oppMissedShots+=1;
	}
	
	public void incUserTimeouts() {
		userTimeouts+=1;
	}
	
	public void incOppTimeouts() {
		oppTimeouts+=1;
	}

	public int getUserTimeouts() {
		return userTimeouts;
	}

	public int getOppTimeouts() {
		return oppTimeouts;
	}

	public int getYear() {
		return year;
	}
	
	public void incUserRebounds() {
		userRebounds+=1;
	}
	
	public void incOppRebounds() {
		oppRebounds+=1;
	}

	public int getUserRebounds() {
		return userRebounds;
	}

	public int getOppRebounds() {
		return oppRebounds;
	}
	
	public void incOppMadeShots() {
		oppMadeShots+=1;
	}
	
	public void incUserMadeShots() {
		userMadeShots+=1;
	}

	public int getUserMadeShots() {
		return userMadeShots;
	}

	public int getOppMadeShots() {
		return oppMadeShots;
	}

	public int getOppMissedShots() {
		return oppMissedShots;
	}

	public int getOppAssists() {
		return oppAssists;
	}

	public int getOppSteals() {
		return oppSteals;
	}

	public int getOppBlocks() {
		return oppBlocks;
	}

	public int getUserMissedShots() {
		return userMissedShots;
	}

	public int getUserAssists() {
		return userAssists;
	}

	public int getUserTurnovers() {
		return userTurnovers;
	}

	public int getUserSteals() {
		return userSteals;
	}

	public int getUserBlocks() {
		return userBlocks;
	}
	
	public void incUserWin() {
		userWin+=1;
	}
	
	public void incUserLoss() {
		userLoss+=1;
	}

	public int getUserWin() {
		return userWin;
	}

	public int getUserLoss() {
		return userLoss;
	}
	
	
}
