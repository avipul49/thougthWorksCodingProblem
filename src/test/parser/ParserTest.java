package test.parser;

import static org.junit.Assert.assertEquals;
import main.model.Talk;
import main.parser.Parser;

import org.junit.Test;

public class ParserTest {

	@Test
	public void shouldParseSessionLenghtFromGivenSessionWithLengthInMin() {
		// given
		String rawSession = "Writing Fast Tests Against Enterprise Rails 60min";
		Parser parser = new Parser();
		Talk expectedSession = new Talk(rawSession);
		expectedSession.setLength(60);

		// when
		Talk actualSession = parser.parse(rawSession);

		// then
		assertEquals(expectedSession.getLength(), actualSession.getLength());
	}

	@Test
	public void shouldParseSessionLenghtFromLightningSessions() {
		// given
		String rawSession = "Rails for Python Developers lightning";
		Parser parser = new Parser();
		Talk expectedSession = new Talk(rawSession);
		expectedSession.setLength(5);

		// when
		Talk actualSession = parser.parse(rawSession);

		// then
		assertEquals(expectedSession.getLength(), actualSession.getLength());
	}

}
