package utils;

import data.CategoryName;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public final class Utils {
    protected static final Logger LOGGER = LoggerUtil.getInstance();

    private Utils() {
    }

    public static void storeProductNamesFoFile(CategoryName categoryName, String productsNames) {
        String fileName = "ProductNamesFor" + categoryName.getValue() + ".txt";
        try {
            File file = new File("src/test/resources/" + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(productsNames);
            file.getAbsolutePath();
            bw.close();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
