package test.model;

import static org.junit.Assert.assertEquals;
import main.model.Talk;
import main.model.Track;

import org.junit.Test;

public class TrackTest {

	@Test
	public void shouldReturnTrueIfTalkPossibleBeforeLunch() {
		// given
		Track track = new Track();
		track.setTime(540);
		Talk talk = new Talk("Some Event");
		talk.setLength(60);
		boolean expectedPossibility = true;

		// when
		boolean actualPossibility = track.isPossible(talk);

		// then
		assertEquals(expectedPossibility, actualPossibility);
	}

	@Test
	public void shouldReturnFalseIfTalkNotPossibleBeforeLunch() {
		// given
		Track track = new Track();
		track.setTime(700);
		Talk talk = new Talk("Some Event");
		talk.setLength(60);
		boolean expectedPossibility = false;

		// when
		boolean actualPossibility = track.isPossible(talk);

		// then
		assertEquals(expectedPossibility, actualPossibility);
	}

	@Test
	public void shouldReturnFalseIfTalkNotPossibleBefore5() {
		// given
		Track track = new Track();
		track.setTime(1000);
		Talk talk = new Talk("Some Event");
		talk.setLength(60);
		boolean expectedPossibility = false;

		// when
		boolean actualPossibility = track.isPossible(talk);

		// then
		assertEquals(expectedPossibility, actualPossibility);
	}

	@Test
	public void shouldReturnTrueIfTalkPossibleBefore5() {
		// given
		Track track = new Track();
		track.setTime(960);
		Talk talk = new Talk("Some Event");
		talk.setLength(60);
		boolean expectedPossibility = true;

		// when
		boolean actualPossibility = track.isPossible(talk);

		// then
		assertEquals(expectedPossibility, actualPossibility);
	}

	@Test
	public void shouldAddATalk() {
		// given
		Track track = new Track();
		track.setTime(560);
		Talk talk = new Talk("Some talk");
		talk.setLength(60);
		int expectedTime = 620;

		// when
		track.addTalk(talk);
		int actualTime = track.getTime();

		// then
		assertEquals(expectedTime, actualTime);
		assertEquals(track.getTalks().size(), 1);
		assertEquals(track.getTalks().get(0).getTalk(), talk);

	}
}
