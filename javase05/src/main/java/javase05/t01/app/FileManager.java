package javase05.t01.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import javase05.t01.commands.core.Command;
import javase05.t01.commands.core.CommandsManager;

public class FileManager extends CommandsManager {
	private String currentPath;

	public FileManager() {
		this(Paths.get("").toAbsolutePath().toString());
	}

	public FileManager(String currentPath) {
		this(new ArrayList<Command>());
		this.currentPath = currentPath;

		/*
		 * cd command
		 */
		commands.add(new Command("cd", "Cмена текущей папки.") {
			@Override
			public void execute() {

				if (!isArgsEmpty() && new File(args[0]).exists()) {
					String path = (Paths.get(args[0]).isAbsolute()) ? args[0] : getCurrentPath() + "\\" + args[0];

					setCurrentPath(path);
				}
			}
		});

		/*
		 * exit command
		 */
		commands.add(new Command("exit", "Завершает работу программы.") {
			@Override
			public void execute() {
				System.out.println();
				System.out.print("Завершение работы программы");

				for (int i = 0; i < 3; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					System.out.print(".");
				}

				System.out.println();
				System.exit(0);
			}
		});

		/*
		 * dir command
		 */
		commands.add(new Command("dir", "Вывод списка файлов из указанной папки.") {
			@SuppressWarnings("unchecked")
			@Override
			public void execute() {

				Iterator<File> iterateFiles = FileUtils.iterateFiles(new File(getCurrentPath()), null, true);

				System.out.println();
				while (iterateFiles.hasNext()) {
					System.out.println(iterateFiles.next().getName());
				}
				System.out.println();

			}
		});

		/*
		 * help command
		 */
		commands.add(new Command("help", "Выводит справочную информацию о командах.") {
			@Override
			public void execute() {
				System.out.println();
				for (Command command : commands) {
					System.out.println(command);
				}
				System.out.println();
			}
		});

		/*
		 * mkdir command
		 */
		commands.add(new Command("mkdir", "Создает каталог.") {
			@Override
			public void execute() {
				if (!isArgsEmpty()) {
					try {
						File file = (Paths.get(args[0]).isAbsolute()) ? new File(args[0])
								: new File(getCurrentPath() + "\\" + args[0]);

						FileUtils.forceMkdir(file);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});

		/*
		 * del command
		 */
		commands.add(new Command("del", "Удаляет файл/каталог.") {
			@Override
			public void execute() {
				if (!isArgsEmpty()) {
					try {
						File file = (Paths.get(args[0]).isAbsolute()) ? new File(args[0])
								: new File(getCurrentPath() + "\\" + args[0]);

						if (file.exists()) {
							FileUtils.forceDelete(file);
							System.out.println("Файл " + file.getName() + " успешно удалён.");
							return;
						}

						System.out.println("Файл или каталог не найден.");
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});

		/*
		 * mkfile command
		 */
		commands.add(new Command("mkfile", "Создает файл.") {
			@Override
			public void execute() {
				if (!isArgsEmpty()) {
					try {
						File file = (Paths.get(args[0]).isAbsolute()) ? new File(args[0])
								: new File(getCurrentPath() + "\\" + args[0]);

						if (file.createNewFile()) {
							System.out.println("Файл " + file.getName() + " успешно создан.");
							return;
						}
						System.out.println("Такой файл уже существует.");
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});

		/*
		 * append command
		 */
		commands.add(new Command("append", "Записывает информацию в текстовый файл.") {
			@Override
			public void execute() {
				if (args.length == 2) {
					try {
						String path = (Paths.get(args[0]).isAbsolute()) ? args[0] : getCurrentPath() + "\\" + args[0];

						BufferedWriter bw = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.APPEND);
						bw.write(args[1]);
						bw.close();

						System.out.println("Операция записи успешно завершена.");
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});

		commands.sort(null);
	}

	public FileManager(List<Command> commands) {
		super(commands);
	}

	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
}
