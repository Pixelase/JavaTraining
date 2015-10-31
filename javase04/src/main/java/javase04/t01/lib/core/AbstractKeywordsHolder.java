package javase04.t01.lib.core;

import java.io.IOException;
import java.util.List;

import javase04.t01.lib.input.Reader;

public abstract class AbstractKeywordsHolder {
	protected String keywordsDbPath;
	protected Reader reader;
	protected List<String> keywords;

	protected AbstractKeywordsHolder(String keywordsDbPath, Reader reader) throws IOException {
		this(keywordsDbPath, reader, reader.readAll());
	}

	private AbstractKeywordsHolder(String keywordsDbPath, Reader reader, List<String> keywords) throws IOException {
		super();
		this.keywordsDbPath = keywordsDbPath;
		this.reader = reader;
		this.keywords = keywords;
	}

	public String getKeywordsDbPath() {
		return keywordsDbPath;
	}

	public void setKeywordsDbPath(String keywordsDbPath) throws IOException {
		this.keywordsDbPath = keywordsDbPath;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
}
