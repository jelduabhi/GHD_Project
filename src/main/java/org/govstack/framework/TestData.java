package org.govstack.framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestData extends ExcelData{

    private static final ThreadLocal<ConcurrentHashMap<String, String>> testDataMap = new ThreadLocal<>();

    public static void readTestData(String testCaseNumber, String sheetName) {
        TestData.testDataMap.set(readExcelData(testCaseNumber, sheetName));
    }

    public static String getData(String key) {
        return TestData.testDataMap.get().getOrDefault(key, null);
    }

    public static void endThreadLocal() {
        testDataMap.remove();
    }
}
