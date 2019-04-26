package org.rapidpm.vaadin.sessionplanner.services.session.modell;

public class Session
    extends SessionBase {
  /**
   * The abstract of the session. Formated with Markdown
   */
  private String abstractText;

  public String getAbstractText() {
    return abstractText;
  }

  public void setAbstractText(String abstractText) {
    this.abstractText = abstractText;
  }
}
