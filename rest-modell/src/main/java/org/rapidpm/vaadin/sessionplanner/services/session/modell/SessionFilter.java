package org.rapidpm.vaadin.sessionplanner.services.session.modell;

import javax.ws.rs.QueryParam;

public class SessionFilter {

  @QueryParam("nameContains")
  private String nameContains;

  public String getNameContains() {
    return nameContains;
  }

  public void setNameContains(String nameContains) {
    this.nameContains = nameContains;
  }
}
