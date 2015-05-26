package main.factory;

import java.util.ArrayList;

import main.TrackManager;
import main.model.Conference;
import main.model.Track;
import main.parser.Parser;

public class Factory {
	private static ArrayList<Track> tracks = new ArrayList<Track>();
	private static Parser parser = new Parser();
	static {
		tracks.add(new Track());
		tracks.add(new Track());
	}

	public static void initConference(Conference conference) {
		conference.setTracks(tracks);
	}

	public static void initTrackManager(TrackManager trackManager) {
		trackManager.setParser(parser);
	}
}
