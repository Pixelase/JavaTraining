package com.github.pixelase.webproject.webapp.panel.layout.footer.i18n;

import com.github.pixelase.webproject.webapp.app.BasicAuthenticationSession;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.Locale;

/**
 * Created by Alexander Babai on 06.01.2016.
 */
public class LanguageSelectionPanel extends Panel {
    public LanguageSelectionPanel(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final LangSelectionLink ruLink = new LangSelectionLink("ru");
        final LangSelectionLink enLink = new LangSelectionLink("en");

        add(ruLink);
        add(enLink);
    }

    private final class LangSelectionLink extends Link<Void> {
        public LangSelectionLink(String id) {
            super(id);
        }

        @Override
        protected void onConfigure() {
            super.onConfigure();
            Locale locale = BasicAuthenticationSession.get().getLocale();
            String lang = locale == null ? null : locale.getLanguage();
            if (getId().equals(lang)) {
                add(AttributeModifier.remove("style"));
            } else {
                add(AttributeModifier.append("style", "opacity:0.6;"));
            }
        }

        @Override
        public void onClick() {
            Session.get().setLocale(new Locale(getId()));

        }
    }
}
