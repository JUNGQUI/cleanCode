package com.jklee.cleancode.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StreamStudy {
	public void streamStudy() throws Exception {
		String contents = Files.readString(
				Paths.get("../ war-and-peace.txt"));
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		long count = 0;
		for (String w : words) {
			if (w.length() > 12) count++;
		}
	}
}
