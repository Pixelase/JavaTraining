package javase03.t02.faq.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

import javase03.t02.faq.lib.FaqHandler;

public class FaqConsoleExample {

	public static void main(String[] args) {
		if (args.length == 2) {
			Locale locale = new Locale(args[0], args[1]);
			FaqHandler faqHandler = new FaqHandler("faq", locale);
			CommandPerformer commandPerformer = new FaqCommandPerformer(faqHandler);

			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				do {
					System.out.print("> ");
					commandPerformer.performCommand(br.readLine());
				} while (true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

}
