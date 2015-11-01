package javase04.t04.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javase02.t02.lib.utils.JsonFileSerializer;
import javase02.t02.lib.utils.Serializer;

public class FilmsManager {
	private List<Film> films;
	private Serializer serializer;
	private String dbPath;

	public FilmsManager(String dbPath) {
		this(new ArrayList<Film>(), new JsonFileSerializer(), dbPath);
	}

	public FilmsManager(List<Film> films, Serializer serializer, String dbPath) {
		super();
		this.films = films;
		this.serializer = serializer;
		this.dbPath = dbPath;
	}

	public boolean readBase() throws IOException {

		boolean isReaded = false;

		if (new File(dbPath).exists()) {
			films = Arrays.asList(serializer.Deserialize(dbPath, Film[].class));
			isReaded = true;
		} else {
			isReaded = false;
		}

		return isReaded;
	}

	public void updateOrCreateBase() throws IOException {
		serializer.Serialize(films.toArray(), dbPath);
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public String getDbPath() {
		return dbPath;
	}

	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}
}
