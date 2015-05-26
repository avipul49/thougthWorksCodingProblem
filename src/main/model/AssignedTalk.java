package main.model;

public class AssignedTalk {
	private int startTime = 540;
	private Talk talk;

	public AssignedTalk(int startTime, Talk talk) {
		this.startTime = startTime;
		this.talk = talk;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public Talk getTalk() {
		return talk;
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	private String getFormatedStartTime() {
		int hour = startTime / 60;
		String ampm = hour / 12 == 0 ? "AM" : "PM";
		hour = hour % 12 == 0 ? 12 : hour % 12;

		int min = startTime % 60;
		return String.format("%02d:%02d%s", hour, min, ampm);
	}

	@Override
	public String toString() {
		return String.format("%s %s", getFormatedStartTime(),
				talk.getSessionInfo());
	}
}
