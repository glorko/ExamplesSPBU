package net.punklan.glorfindeil;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.DataProviderListener;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.data.provider.Query;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        List<Entity> some = new ArrayList<>();
        some.addAll(Arrays.asList(new Entity("dgg", LocalDateTime.MAX, 44),
                new Entity("Another", LocalDateTime.MIN, 66),
                new Entity(null, LocalDateTime.now(), 11)));


        final Grid<Entity> grid = new Grid<>();
        layout.addComponent(grid);
        grid.getData();

        ListDataProvider<String> dataProvider =
                DataProvider.ofCollection(Arrays.asList("dg", "dfgdfg"));
        dataProvider.addFilter(s -> {
            return s.contains("sd");
        });
        dataProvider.clearFilters();
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue()
                    + ", it works!"));

            some.add(new Entity(name.getValue(), LocalDateTime.now(),
                    99));
            grid.setItems(some);
        });

        layout.addComponents(name, button);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
