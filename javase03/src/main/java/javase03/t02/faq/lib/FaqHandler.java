package javase03.t02.faq.lib;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

public class FaqHandler {
	private Map<String, String> faq;
	private ResourceBundle resourceBundle;
	private String baseBundleName;

	public FaqHandler() {
		this("faq", Locale.getDefault());
	}

	public FaqHandler(String baseBundleName, Locale locale) {
		super();
		faq = new HashMap<>();
		this.baseBundleName = baseBundleName;
		setLocale(locale);
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setLocale(Locale locale) {
		resourceBundle = PropertyResourceBundle.getBundle(baseBundleName, locale);

		Enumeration<String> keys = resourceBundle.getKeys();
		String tempKey;
		faq.clear();
		while (keys.hasMoreElements()) {
			tempKey = keys.nextElement();
			faq.put(tempKey, resourceBundle.getString(tempKey));
		}
	}

	public Map<String, String> getFaq() {
		return faq;
	}

	public Set<String> getQuestions() {
		return faq.keySet();
	}

	public Collection<String> getAnswers() {
		return faq.values();
	}
}
