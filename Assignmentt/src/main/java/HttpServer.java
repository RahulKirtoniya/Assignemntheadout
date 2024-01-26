import spark.Request;
import spark.Response;
import spark.Spark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HttpServer {
    public static void main(String[] args) {
        Spark.port(8080);

        Spark.get("/data", (req, res) -> handleRequest(req, res));
    }

    private static String handleRequest(Request req, Response res) {
        String fileName = req.queryParams("n");
        String lineNumber = req.queryParams("m");

        if (fileName == null || fileName.isEmpty()) {
            return "Invalid request: Missing file name";
        }

        String filePath = "/tmp/data/" + fileName + ".txt";

        if (lineNumber != null && !lineNumber.isEmpty()) {
            int lineNum = Integer.parseInt(lineNumber);
            return readLineFromFile(filePath, lineNum);
        } else {
            return readEntireFile(filePath);
        }
    }

    private static String readLineFromFile(String filePath, int lineNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 0;

            while ((line = br.readLine()) != null) {
                currentLine++;

                if (currentLine == lineNumber) {
                    return line;
                }
            }

            return "Line number not found in the file.";
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    private static String readEntireFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }

            return content.toString();
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}
