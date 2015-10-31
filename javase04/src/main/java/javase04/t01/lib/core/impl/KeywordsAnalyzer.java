package javase04.t01.lib.core.impl;

import java.io.IOException;

import javase04.t01.lib.core.AbstractKeywordsAnalyzer;
import javase04.t01.lib.core.AbstractKeywordsHolder;
import javase04.t01.lib.input.Reader;
import javase04.t01.lib.input.imp.ByteStreamReader;
import javase04.t01.lib.output.Writer;
import javase04.t01.lib.output.impl.ByteStreamWriter;

public class KeywordsAnalyzer extends AbstractKeywordsAnalyzer {

	public KeywordsAnalyzer(String keywordsDbPath, String sourceFilePath, String resultPath) throws IOException {
		this(new ByteStreamWriter(resultPath), new ByteStreamReader(sourceFilePath), new KeywordsHolder(keywordsDbPath),
				keywordsDbPath, sourceFilePath, resultPath);
	}

	protected KeywordsAnalyzer(Writer writer, Reader reader, AbstractKeywordsHolder keywordsHolder,
			String keywordsDbPath, String sourceFilePath, String resultPath) {
		super(writer, reader, keywordsHolder, keywordsDbPath, sourceFilePath, resultPath);
	}

	@Override
	public void setSourceFilePath(String sourceFilePath) {
		super.setSourceFilePath(sourceFilePath);
		reader = new ByteStreamReader(sourceFilePath);
	}
}
