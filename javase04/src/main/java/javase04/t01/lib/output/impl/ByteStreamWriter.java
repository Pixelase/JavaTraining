package javase04.t01.lib.output.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Map.Entry;

import javase04.t01.lib.output.Writer;

public class ByteStreamWriter implements Writer {
	protected final String path;

	public ByteStreamWriter(String path) {
		super();
		this.path = path;
	}

	@Override
	public void writeAll(Map<String, Integer> map) throws IOException {
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(path))));

		for (Entry<String, Integer> entry : map.entrySet()) {
			out.printf("%s : %d\n", entry.getKey(), entry.getValue());
		}

		out.close();
	}

}
