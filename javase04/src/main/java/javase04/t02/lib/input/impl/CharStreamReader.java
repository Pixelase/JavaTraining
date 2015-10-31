package javase04.t02.lib.input.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javase04.t01.lib.input.Reader;

public class CharStreamReader implements Reader {
	protected final String path;

	public CharStreamReader(String path) {
		super();
		this.path = path;
	}

	@Override
	public List<String> readAll() throws IOException {
		List<String> result = new ArrayList<>();
		BufferedReader in = new BufferedReader(new FileReader(new File(path)));

		String line;
		while ((line = in.readLine()) != null) {
			result.add(line);
		}

		in.close();

		return result;
	}

	public String getPath() {
		return path;
	}

}
