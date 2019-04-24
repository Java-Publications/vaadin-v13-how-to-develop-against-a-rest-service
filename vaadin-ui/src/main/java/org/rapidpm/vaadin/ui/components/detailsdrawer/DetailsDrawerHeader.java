package org.rapidpm.vaadin.ui.components.detailsdrawer;

import com.vaadin.flow.component.html.Label;
import org.rapidpm.vaadin.ui.util.BoxShadowBorders;
import org.rapidpm.vaadin.ui.util.LumoStyles;
import org.rapidpm.vaadin.ui.util.UIUtils;
import org.rapidpm.vaadin.ui.util.css.BoxSizing;

public class DetailsDrawerHeader extends Label {

    public DetailsDrawerHeader(String title, boolean tabs) {
        super(title);

        // Default styling
        addClassNames(LumoStyles.Heading.H3,
                LumoStyles.Padding.Responsive.Horizontal.L,
                LumoStyles.Padding.Top.L);
        UIUtils.setBoxSizing(BoxSizing.BORDER_BOX, this);
        setWidth("100%");

        // Styling based on whether this component will share the DetailsDrawer
        // header slot with Tabs
        if (tabs) {
            addClassName(LumoStyles.Padding.Bottom.M);
        } else {
            addClassNames(BoxShadowBorders.BOTTOM, LumoStyles.Padding.Bottom.L);
        }
    }

    public DetailsDrawerHeader(String title) {
        this(title, false);
    }

}
