package main.model;

import java.util.ArrayList;

import main.factory.Factory;

public class Conference {
	private ArrayList<Talk> remainingTalks = new ArrayList<Talk>();
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public Conference(ArrayList<Talk> talks) {
		Factory.initConference(this);
		this.remainingTalks = new ArrayList<Talk>(talks);
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = new ArrayList<Track>(tracks);
	}

	public boolean isComplete() {
		return remainingTalks.isEmpty();
	}

	public Conference clone() {
		Conference clone = new Conference(remainingTalks);
		ArrayList<Track> newTracks = new ArrayList<Track>();
		for (Track track : tracks) {
			newTracks.add(track.clone());
		}
		clone.setTracks(newTracks);
		return clone;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public ArrayList<Talk> getRemainingTalks() {
		return remainingTalks;
	}

	public boolean isPossible(int i, Talk talk) {
		return tracks.get(i).isPossible(talk);
	}

	public void addTalk(int i, Talk talk) {
		tracks.get(i).addTalk(talk);
		remainingTalks.remove(talk);
	}

	@Override
	public String toString() {
		String s = "";
		int i = 1;
		for (Track track : tracks) {
			s += ("\nTrack " + i + " " + track);
			i++;
		}
		return s;
	}
}
