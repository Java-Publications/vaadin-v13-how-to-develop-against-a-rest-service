package org.rapidpm.vaadin.demo.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.rapidpm.vaadin.ui.MainLayout;
import org.rapidpm.vaadin.ui.components.FlexBoxLayout;
import org.rapidpm.vaadin.ui.layout.size.Horizontal;
import org.rapidpm.vaadin.ui.layout.size.Vertical;
import org.rapidpm.vaadin.ui.views.ViewFrame;

@Route(value = "home", layout = MainLayout.class)
@PageTitle("Welcome")
public class Home extends ViewFrame {

    public Home() {
        setId("home");
        setViewContent(createContent());
    }

    private Component createContent() {
        Html text = new Html(
                "<span>A responsive application template with some dummy data. "
                + "Loosely based on the <b>responsive layout grid</b> "
                + "guidelines set by <a href=\"https://material.io/design/layout/responsive-layout-grid.html\">Material Design</a>. Utilises the <a href=\"https://vaadin.com/themes/lumo\">Lumo</a> theme.</span>");

        FlexBoxLayout content = new FlexBoxLayout(text);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Horizontal.RESPONSIVE_L, Vertical.L);
        return content;
    }

}
