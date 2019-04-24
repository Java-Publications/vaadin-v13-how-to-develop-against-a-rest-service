package org.rapidpm.vaadin.ui.components.navigation.drawer;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.server.StreamResource;
import org.rapidpm.vaadin.ui.components.navigation.bar.AppBar;
import org.rapidpm.vaadin.ui.util.UIUtils;

import static org.rapidpm.vaadin.ui.util.UIUtils.IMG_PATH;

public class BrandExpression extends Composite<Div> {

    private String CLASS_NAME = "brand-expression";

    private Image logo;
    private Label title;

    public BrandExpression(String text) {
        getContent().setClassName(CLASS_NAME);

        //TODO conszumized from outside
//        logo = new Image(UIUtils.IMG_PATH + "images/logo-18.png", "");
        logo = new Image(new StreamResource( "IMG_NAME",
                                               () -> BrandExpression.class.getResourceAsStream( IMG_PATH + "logo-18.png" )),
                           "Company logo"
        );
        logo.addClassName(CLASS_NAME + "__logo");
        logo.setAlt(text + " logo");

        title = UIUtils.createH3Label(text);
        title.addClassName(CLASS_NAME + "__title");

        getContent().add(logo, title);
    }

}
