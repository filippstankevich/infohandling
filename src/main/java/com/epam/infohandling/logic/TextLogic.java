package com.epam.infohandling.logic;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;

public class TextLogic {

    public Composite calculate(Composite text) {
		return text;
    	
       
    }

    public String restore(Composite text) {
    	StringBuilder sb = new StringBuilder();
		for(int i = 0; i < text.childrenCount(); i++) {
			Composite child = (Composite)text.getChild(i);
			sb.append("\t");
			for(int j = 0; j < child.childrenCount(); j++) {
				Composite childLevel2 =  (Composite)child.getChild(j);
				for(int z = 0; z < childLevel2.childrenCount(); z++) {
					Leaf childLevel3 =  (Leaf)childLevel2.getChild(z);
					sb.append(childLevel3.getValue()).append(" ");
				}
				sb.append("\n");
			}
		}
		return sb.toString();
        
    }
    
    public Composite reverse(Composite text) {
		return text;
    	
    }
}
