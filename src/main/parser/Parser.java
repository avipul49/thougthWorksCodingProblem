package main.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.model.Talk;

public class Parser {

	public Talk parse(String rawSession) {
		Talk talk = new Talk(rawSession);
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(rawSession);
		if (m.find())
			talk.setLength(Integer.parseInt(m.group()));
		else {
			talk.setLength(5);
		}
		return talk;
	}
}
