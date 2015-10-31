package javase04.t01.lib.input;

import java.io.IOException;
import java.util.List;

public interface Reader {
	List<String> readAll() throws IOException;
}
