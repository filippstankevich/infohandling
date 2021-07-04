package com.epam.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> chields = new ArrayList<Component>();
    private String end;

    public Composite(String end) {
        this.end = end;
    }

    @Override
    public void add(Component component) {
        chields.add(component);
    }

    @Override
    public Object getChild(int index) {
        return chields.get(index);
    }

    @Override
    public void restoreText(StringBuilder text) {
        for (Component component : chields) {
            component.restoreText(text);
        }
        text.deleteCharAt(text.length() - 1);
        text.append(end);
    }

    @Override
    public void calculateExp() {
        for (Component component : chields) {
            component.calculateExp();
        }
    }

    @Override
    public void remove(Component component) {
        chields.remove(component);

    }

}
