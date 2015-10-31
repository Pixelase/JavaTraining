package javase04.t01.app;

import java.io.IOException;

import javase04.t01.lib.core.Analyser;
import javase04.t01.lib.core.impl.KeywordsAnalyzer;

public class JavaKeywordsAnalyzer {
	public static void main(String[] args) throws IOException {
		String keywordsDbPath = "C:\\JavaEEWorkspaceClean\\JavaTraining\\javase04\\src\\main\\resources\\java_keywords.txt";
		String sourceFilePath = "C:\\JavaEEWorkspaceClean\\JavaTraining\\javase04\\src\\main\\java\\javase04\\t01\\lib\\core\\AbstractKeywordsAnalyzer.java";
		String resultPath = "C:\\JavaEEWorkspaceClean\\JavaTraining\\javase04\\src\\main\\resources\\result.txt";

		Analyser analyser = new KeywordsAnalyzer(keywordsDbPath, sourceFilePath, resultPath);
		analyser.analyze();

	}
}
