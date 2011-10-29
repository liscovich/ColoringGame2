package edu.harvard.med.hcp.mcknight.game.moves;

import java.text.DateFormat;

import edu.harvard.med.hcp.mcknight.game.Player;

/**
 * The player chooses to cooperate this round.
 * @author Mark McKnight
 */
public class DoNotCooperateMove extends PlayerMove {
	private String decisionMaker;
	public DoNotCooperateMove(Player p, String decisionMaker) {
		super(p, p.getGame().getCurRound());
		this.decisionMaker = decisionMaker;
	}

	@Override
	public void doMove() {
		player.setCooperation(0, decisionMaker);
	}

	@Override
	public String toCSV()
	{
		String returnString = "";
		returnString += timestamp + ", ";
		returnString += getRound() + ", ";
		returnString += player.getGame().getGid() + ", ";
		returnString += player.getId() + ", ";
		returnString += "Defect; affect to players: ";
		for (Player neighbor : player.getNeighbors()) {
			returnString += neighbor.getId() + ", ";
		}

		return returnString;
	}

	@Override
	public String toString()
	{
		return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(timestamp) + ": \t" + player.getName() + " decided NOT to cooperate.";
	}
}
