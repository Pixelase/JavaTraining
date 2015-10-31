package javase04.t01.lib.core;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import javase04.t01.lib.input.Reader;
import javase04.t01.lib.output.Writer;

public abstract class AbstractKeywordsAnalyzer implements Analyser {
	protected Writer writer;
	protected Reader reader;
	protected AbstractKeywordsHolder keywordsHolder;
	protected String sourceFilePath;
	protected String resultPath;

	protected AbstractKeywordsAnalyzer(Writer writer, Reader reader, AbstractKeywordsHolder keywordsHolder,
			String keywordsDbPath, String sourceFilePath, String resultPath) {
		super();
		this.writer = writer;
		this.reader = reader;
		this.keywordsHolder = keywordsHolder;
		this.sourceFilePath = sourceFilePath;
		this.resultPath = resultPath;
	}

	public void analyze() throws IOException {
		Map<String, Integer> result = new LinkedHashMap<>();

		for (String line : reader.readAll()) {

			for (String keyword : keywordsHolder.getKeywords()) {

				int countMatches = (result.containsKey(keyword))
						? result.get(keyword) + StringUtils.countMatches(line, keyword)
						: StringUtils.countMatches(line, keyword);

				if (countMatches != 0) {
					result.put(keyword, countMatches);
				}
			}
		}

		writer.writeAll(result);
	}

	public String getKeywordsDbPath() {
		return keywordsHolder.getKeywordsDbPath();
	}

	public void setKeywordsDbPath(String keywordsDbPath) throws IOException {
		keywordsHolder.setKeywordsDbPath(keywordsDbPath);
	}

	public String getSourceFilePath() {
		return sourceFilePath;
	}

	public void setSourceFilePath(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
	}

	public String getResultPath() {
		return resultPath;
	}

	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}
}
