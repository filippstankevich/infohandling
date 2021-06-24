package com.epam.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public  void remove(Component component){
        components.remove(component);
    }

    @Override
    public void operation() {
        for (Component component: components) {
            component.operation();
        }
    }

    @Override
    public Object getChild(int index) {
        return components.get(index);
    }
}