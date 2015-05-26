package main.model;

public class Talk {

	private int length;
	private String talkInfo;

	public Talk(String rawSession) {
		this.talkInfo = rawSession;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getSessionInfo() {
		return talkInfo;
	}

	public void setSessionInfo(String sessionInfo) {
		this.talkInfo = sessionInfo;
	}

}
