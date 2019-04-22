package junit.org.rapidpm.vaadin.sessionplanner.services;

import com.vaadin.flow.i18n.I18NProvider;
import org.junit.jupiter.api.Test;
import org.rapidpm.vaadin.sessionplanner.services.I18NProviderImpl;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class I18NProviderTest {


  @Test void test000() {
    assertEquals(Locale.GERMAN, Locale.GERMAN);
  }

  @Test void test001() {
    final I18NProvider i18NProvider = new I18NProviderImpl();

    final List<Locale> providedLocales = i18NProvider.getProvidedLocales();
    assertEquals(2, providedLocales.size());
    //assume that there is a key : provider.test=german/english/default
    assertEquals("english", i18NProvider.getTranslation("provider.test", Locale.ENGLISH, null));
  }
}
