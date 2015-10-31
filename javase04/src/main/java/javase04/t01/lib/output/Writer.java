package javase04.t01.lib.output;

import java.io.IOException;
import java.util.Map;

public interface Writer {
	void writeAll(Map<String, Integer> lines) throws IOException;
}
