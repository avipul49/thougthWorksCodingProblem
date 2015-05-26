package main.model;

import java.util.ArrayList;

public class Track {
	private ArrayList<AssignedTalk> talks = new ArrayList<AssignedTalk>();
	private int time = 540;
	private final int LUNCH_TIME = 720;
	private final int END_TIME = 1020;
	private final int LUNCH_END = 780;

	public ArrayList<AssignedTalk> getTalks() {
		return talks;
	}

	public void addTalk(Talk talk) {
		talks.add(new AssignedTalk(time, talk));
		time += talk.getLength();
		if (time == LUNCH_TIME) {
			addLunch();
		}
	}

	private void addLunch() {
		time = LUNCH_END;
		talks.add(new AssignedTalk(LUNCH_TIME, new Talk("Lunch")));
	}

	public Track clone() {
		Track track = new Track();
		track.setTalks(talks);
		track.setTime(time);
		return track;
	}

	public void setTalks(ArrayList<AssignedTalk> talks) {
		this.talks = new ArrayList<AssignedTalk>(talks);
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public boolean isPossible(Talk talk) {
		if (isPossibleBeforeLunchTime(talk))
			return true;
		if (isPossibleAfterLunch(talk))
			return true;
		return false;
	}

	private boolean isPossibleAfterLunch(Talk talk) {
		return time >= LUNCH_END && time + talk.getLength() <= END_TIME;
	}

	private boolean isPossibleBeforeLunchTime(Talk talk) {
		return time <= LUNCH_TIME && time + talk.getLength() <= LUNCH_TIME;
	}

	@Override
	public String toString() {
		String s = "";
		for (AssignedTalk talk : talks) {
			s += ("\n" + talk);
		}
		s += addNetworkingEvent();
		return s;
	}

	private String addNetworkingEvent() {
		AssignedTalk neworkingEvent = new AssignedTalk(time, new Talk(
				"Networking Event"));
		return ("\n" + neworkingEvent);
	}
}
