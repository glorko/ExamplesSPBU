package net.punklan.glorfindeil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by st020794 on 07.04.2017.
 */
@SpringUI
public class MyUI extends UI {

    @Autowired
    CreditCalculator calc;

    @Autowired
    ObjectMapper mapper;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Credit credit = new Credit(100, "some credit");
        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(new Label(calc.calculateAllCredits() + ""));
        try {
            layout.addComponent(new Label(mapper.writeValueAsString(credit)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        setContent(layout);
    }
}

