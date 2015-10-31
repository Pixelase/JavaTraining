package javase04.t02.lib.core.impl;

import java.io.IOException;

import javase04.t01.lib.core.AbstractKeywordsHolder;
import javase04.t01.lib.input.Reader;
import javase04.t02.lib.input.impl.CharStreamReader;

public class KeywordsHolder extends AbstractKeywordsHolder {
	public KeywordsHolder(String keywordsDbPath) throws IOException {
		this(keywordsDbPath, new CharStreamReader(keywordsDbPath));
	}

	protected KeywordsHolder(String keywordsDbPath, Reader reader) throws IOException {
		super(keywordsDbPath, reader);
	}

	@Override
	public void setKeywordsDbPath(String keywordsDbPath) throws IOException {
		super.setKeywordsDbPath(keywordsDbPath);
		reader = new CharStreamReader(keywordsDbPath);
		keywords = reader.readAll();
	}
}
