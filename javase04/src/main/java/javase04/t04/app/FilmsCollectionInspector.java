package javase04.t04.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javase04.t04.core.Actor;
import javase04.t04.core.Film;
import javase04.t04.core.FilmsManager;
import javase04.t04.core.Genre;

public class FilmsCollectionInspector {

	private final static Random rand = new Random();

	public static <T> void printList(List<T> items) {
		for (T item : items) {
			System.out.println(item);
		}
	}

	public static List<Film> generateFilms(int filmsCount, int maxActorsCount) {

		List<Film> films = new ArrayList<>();
		List<Actor> actors = generateActors(maxActorsCount);
		int maxMoneyCount = 999999;

		for (int i = 0; i < filmsCount; i++) {
			int actorsCount = rand.nextInt(maxActorsCount - 1);
			actorsCount = (actorsCount == 0) ? 3 : actorsCount;

			films.add(new Film("Film" + i, new Long(rand.nextInt(maxMoneyCount)), new Long(rand.nextInt(maxMoneyCount)),
					new Date(), generateGenres(), actors.subList(0, actorsCount)));
		}

		return films;
	}

	public static List<Actor> generateActors(int actorsCount) {
		List<Actor> actors = new ArrayList<>();

		for (int i = 0; i < actorsCount; i++) {
			actors.add(new Actor("Jason", "Statham" + i, new Date(), "\"Shirebrook, Derbyshire, England, UK\""));
		}

		return actors;
	}

	public static List<Genre> generateGenres() {
		List<Genre> genres = new ArrayList<>();
		int genresCount = Genre.values().length;

		for (int i = 0; i < rand.nextInt(genresCount); i++) {
			genres.add(Genre.values()[rand.nextInt(genresCount - 1)]);
		}

		return genres;
	}

	public static void main(String[] args) throws IOException {
		int filmsCount = 5;
		int maxActorsCount = 10;

		List<Film> films = generateFilms(filmsCount, maxActorsCount);
		String dbPath = "C:\\JavaEEWorkspaceClean\\JavaTraining\\javase04\\src\\main\\resources\\films.json";
		FilmsManager manager = new FilmsManager(dbPath);

		if (!manager.readBase()) {
			manager.setFilms(films);
			manager.setDbPath(dbPath);
		}

		/*
		 * Original films from base or recently created
		 */
		System.out.println("> Original films:\n");
		printList(manager.getFilms());

		/*
		 * Edit some films
		 */
		manager.getFilms().get(rand.nextInt(filmsCount - 1)).setTitle("Edited film");
		manager.getFilms().get(rand.nextInt(filmsCount - 1)).setTitle("New film");

		/*
		 * Edit some actor. This will change the data for all the films where
		 * actor is present.
		 */
		manager.getFilms().get(rand.nextInt(filmsCount - 1)).getActors().get(0).setFirstName("Updated Jason");

		System.out.println("==============================\n\n");
		System.out.println("> Edited films:\n");
		printList(manager.getFilms());

		manager.updateOrCreateBase();

	}

}
