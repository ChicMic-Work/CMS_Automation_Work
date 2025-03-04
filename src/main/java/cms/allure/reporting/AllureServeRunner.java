package cms.allure.reporting;

import org.testng.IExecutionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AllureServeRunner implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        // Code to run before the suite starts
    }

    @Override
    public void onExecutionFinish() {
        // Code to run after the suite finishes
        runAllureServe();
    }

    public static void runAllureServe() {
        String allureResultsPath = getAllureResultsPath();
        try {
            ProcessBuilder processBuilder;
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // For Windows
                processBuilder = new ProcessBuilder("cmd.exe", "/c", "allure serve " + allureResultsPath);
            } else {
                // For Unix-based systems (e.g., macOS, Linux)
                processBuilder = new ProcessBuilder("/bin/sh", "-c", "allure serve " + allureResultsPath);
            }

            // Print the command for debugging purposes
            System.out.println("Running command: " + String.join(" ", processBuilder.command()));

            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getAllureResultsPath() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String allureResultsDir = properties.getProperty("allure.results.path", "allure-results");

        // Get the project root directory
        String projectRoot = new File("").getAbsolutePath();

        // Construct the full path to the allure results directory
        return new File(projectRoot, allureResultsDir).getAbsolutePath();
    }

    public static void main(String[] args) {
        runAllureServe();
    }
}

