package com.epam.infohandling;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.parsing.ChainBuilder;
import com.epam.infohandling.parsing.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextProcessor {
    private static final Logger logger = LogManager.getLogger(TextProcessor.class);

    public Composite parseText(String text) {

        logger.info("parseText start");
        Parser parser = new ChainBuilder().build();
        logger.info("Parser created");
        return parser.parse(text);
    }
}
