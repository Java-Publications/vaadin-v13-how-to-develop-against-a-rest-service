package org.rapidpm.vaadin.sessionplanner.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public abstract class JACKSONModellConverter<T> implements ModelConverter<T> {

  private ObjectMapper objectMapper = new ObjectMapper();

  {
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  public ObjectMapper mapper() {
    return objectMapper;
  }


}
