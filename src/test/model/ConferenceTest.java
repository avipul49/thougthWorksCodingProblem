package test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.model.Conference;
import main.model.Talk;

import org.junit.Test;

public class ConferenceTest {

	@Test
	public void shouldRemoveTheTalkFromRemainingTalksOnceAdded() {
		// given
		Talk talk = new Talk("Some talk");
		talk.setLength(60);
		ArrayList<Talk> talks = new ArrayList<Talk>();
		Conference conference = new Conference(talks);

		// when
		conference.addTalk(0, talk);

		// then
		assertEquals(conference.getRemainingTalks().size(), 0);
	}

}
