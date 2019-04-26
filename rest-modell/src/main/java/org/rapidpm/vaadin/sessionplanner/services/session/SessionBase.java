package org.rapidpm.vaadin.sessionplanner.services.session;

public class SessionBase {
  /**
   * The id of the session
   */
  private int id;
  /**
   * The title of the session
   */
  private String title;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
