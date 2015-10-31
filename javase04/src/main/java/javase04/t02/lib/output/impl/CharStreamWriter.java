package javase04.t02.lib.output.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javase04.t01.lib.output.Writer;

public class CharStreamWriter implements Writer {

	protected final String path;

	public CharStreamWriter(String path) {
		super();
		this.path = path;
	}

	@Override
	public void writeAll(Map<String, Integer> map) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(path))));

		for (Entry<String, Integer> entry : map.entrySet()) {
			out.printf("%s : %d\n", entry.getKey(), entry.getValue());
		}

		out.close();
	}

}
