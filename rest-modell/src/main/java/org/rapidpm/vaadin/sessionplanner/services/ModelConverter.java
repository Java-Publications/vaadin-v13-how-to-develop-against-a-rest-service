package org.rapidpm.vaadin.sessionplanner.services;

import org.rapidpm.frp.model.Result;

public interface ModelConverter<T> {

  Result<T> fromJSON(String json);
  Result<String> toJSON(T value);

}
