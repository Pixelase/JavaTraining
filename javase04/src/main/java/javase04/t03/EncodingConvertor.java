package javase04.t03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncodingConvertor {

	/**
	 * Old way, by using java.io
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void IoConvertEncoding(String path, Charset sourceCharset, Charset targetCharset) throws IOException {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(path)), sourceCharset));

		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = in.readLine()) != null) {
			sb.append(line + "\n");
		}
		in.close();

		BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(new File(path)), targetCharset));

		out.write(sb.toString());
		out.close();
	}

	/**
	 * 
	 * Better way by using java.nio
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void NioConvertEncoding(String path, Charset sourceCharset, Charset targetCharset)
			throws IOException {
		Files.write(Paths.get(path), Files.readAllLines(Paths.get(path), sourceCharset), targetCharset);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String ioFile = "C:\\JavaEEWorkspaceClean\\JavaTraining\\javase04\\src\\main\\resources\\ioFile.txt";
		IoConvertEncoding(ioFile, StandardCharsets.UTF_8, StandardCharsets.UTF_16);

		String nioFile = "C:\\JavaEEWorkspaceClean\\JavaTraining\\javase04\\src\\main\\resources\\nioFile.txt";
		NioConvertEncoding(nioFile, StandardCharsets.UTF_8, StandardCharsets.UTF_16);
	}
}
