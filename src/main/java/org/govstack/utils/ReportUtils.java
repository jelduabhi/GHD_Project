package org.govstack.utils;

import java.io.File;

public class ReportUtils {

    public static void deleteReport() {
        try {
            File reportFile = new File(System.getProperty("user.dir") + "\\allure-results");
            if(reportFile.isDirectory()) {
                File[] content = reportFile.listFiles();
                assert content != null;
                for (File file : content) {
                    if (file.toString().contains(".json")) {
                        if(file.delete()){
                            System.out.println("File Deleted");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void generateReport()  {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(System.getProperty("user.dir") + "\\GenerateReport.bat");
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        generateReport();
    }
}
