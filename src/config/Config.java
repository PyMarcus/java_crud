package config;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 * The type Config.
 */
public class Config {
    private final static String LOGFILE = "crud.log";
    private static final Logger logger = Logger.getLogger(Config.class.getName());

    /**
     * Create your log
     *
     * @param text  the text to register
     * @param level the level -> info, danger, warning
     */
    public static void log(String text, String level) {
        try{
            FileHandler fh = new FileHandler(LOGFILE, true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);


            switch (level.toLowerCase()){
                case "info":
                    logger.info(text);
                    break;
                case "danger":
                    logger.severe(text);
                    break;
                case "warning":
                    logger.warning(text);
                    break;
            }
            fh.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
