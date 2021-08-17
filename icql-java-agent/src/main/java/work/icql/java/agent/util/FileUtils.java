package work.icql.java.agent.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {

    public static String readFile(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return "";
        }
        try {
            StringBuffer sb = new StringBuffer();
            FileUtils.readToBuffer(sb, filePath);
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine();
        while (line != null) {
            buffer.append(line);
            buffer.append("\n");
            line = reader.readLine();
        }
        reader.close();
        is.close();
    }
}
