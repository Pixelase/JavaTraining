package javase02.t02.lib.utils;

import java.io.IOException;

public interface Serializer {

	<T> void Serialize(T employee, String path) throws IOException;

	<T> T Deserialize(String path, Class<T> type) throws IOException;

}
