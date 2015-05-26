package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import main.factory.Factory;
import main.model.Conference;
import main.model.Talk;
import main.parser.Parser;

public class TrackManager {
	private Parser parser;
	private boolean solutionFound = false;
	private Conference solution;

	public TrackManager() {
		Factory.initTrackManager(this);
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	private ArrayList<Talk> getAllTalks() throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		ArrayList<Talk> talks = new ArrayList<Talk>();
		while (in.hasNext()) {
			String rawTalk = in.nextLine();
			talks.add(parser.parse(rawTalk));
		}
		in.close();
		return talks;
	}

	private void writeConfiguredTracks(String conference)
			throws FileNotFoundException {
		PrintWriter out = new PrintWriter("output.txt");
		out.write(conference);
		out.close();
	}

	public Conference configurTracks() throws FileNotFoundException {
		ArrayList<Talk> allTalks = getAllTalks();
		dfs(new Conference(allTalks));
		return solution;
	}

	private void dfs(Conference conference) {
		for (int i = 0; i < conference.getTracks().size(); i++) {
			for (Talk talk : conference.getRemainingTalks()) {
				Conference newConference = conference.clone();
				if (newConference.isPossible(i, talk)) {
					newConference.addTalk(i, talk);
					if (newConference.isComplete()) {
						solutionFound = true;
						solution = newConference;
						return;
					}
					if (!solutionFound)
						dfs(newConference);
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		TrackManager trackManager = new TrackManager();
		Conference conference = trackManager.configurTracks();
		System.out.println(conference);
		trackManager.writeConfiguredTracks(conference.toString());
	}
}
