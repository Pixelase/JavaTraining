package javase04.t01.lib.core.impl;

import java.io.IOException;

import javase04.t01.lib.core.AbstractKeywordsHolder;
import javase04.t01.lib.input.Reader;
import javase04.t01.lib.input.imp.ByteStreamReader;

public class KeywordsHolder extends AbstractKeywordsHolder {

	public KeywordsHolder(String keywordsDbPath) throws IOException {
		this(keywordsDbPath, new ByteStreamReader(keywordsDbPath));
	}

	protected KeywordsHolder(String keywordsDbPath, Reader reader) throws IOException {
		super(keywordsDbPath, reader);
	}

	@Override
	public void setKeywordsDbPath(String keywordsDbPath) throws IOException {
		super.setKeywordsDbPath(keywordsDbPath);
		reader = new ByteStreamReader(keywordsDbPath);
		keywords = reader.readAll();
	}

}
