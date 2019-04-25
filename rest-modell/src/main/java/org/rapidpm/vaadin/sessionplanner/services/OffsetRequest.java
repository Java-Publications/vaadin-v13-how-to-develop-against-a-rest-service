package org.rapidpm.vaadin.sessionplanner.services;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class OffsetRequest {
  @QueryParam("limit")
  @DefaultValue("20")
  private int limit;
  @QueryParam("offset")
  @DefaultValue("0")
  private int offset;

  public OffsetRequest() {
    super();
  }

  public OffsetRequest(int limit, int offset) {
    super();
    this.limit = limit;
    this.offset = offset;
  }

  public int getLimit() {
    return limit;
  }

  public int getOffset() {
    return offset;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }


}
