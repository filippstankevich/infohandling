package com.epam.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private String delimiter;

    public void setLastDelimiterRequired(boolean lastDelimiterRequired) {
        isLastDelimiterRequired = lastDelimiterRequired;
    }

    boolean isLastDelimiterRequired;
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

    public  int childSize(){
        return components.size();
    }

    public String getDelimiter(){
        return delimiter.replaceAll("\\\\", "");
    }

    public void setDelimiter(String delimiter){
        this.delimiter = delimiter;
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).toString().isEmpty()){
                continue;
            }
            result = result + components.get(i).toString();
            if (i != components.size() - 1){
                result = result + getDelimiter();
                if (isLastDelimiterRequired){
                    result = result + " ";
                }
            }
        }
        if (isLastDelimiterRequired){
            result = result + getDelimiter();
        }
        return result;
    }
}