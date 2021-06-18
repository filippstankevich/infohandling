package com.epam.infohandling.parsing;

import java.util.List;
import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public interface Parser {
    Composite parse(String text);
}
