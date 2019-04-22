package org.rapidpm.vaadin.sessionplanner.views.pages;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.rapidpm.vaadin.sessionplanner.MainLayout;

import static org.rapidpm.vaadin.sessionplanner.views.pages.ProfileView.NAV;


@Route(value = NAV, layout = MainLayout.class)
public class ProfileView extends Composite<Div> {
  public static final String NAV = "profile";

  public ProfileView() {
    getContent().add(new Span("Profile"));
  }
}
