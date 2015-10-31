package javase04.t01.lib.input.imp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javase04.t01.lib.input.Reader;

public class ByteStreamReader implements Reader {
	protected final String path;

	public ByteStreamReader(String path) {
		super();
		this.path = path;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<String> readAll() throws IOException {
		List<String> result = new ArrayList<>();
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(path))));

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
