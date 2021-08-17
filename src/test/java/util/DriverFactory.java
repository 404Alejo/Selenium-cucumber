package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    //Chrome driver
    private static final Supplier<WebDriver> chromeDriver = () -> {
        PropertiesLoader pl = new PropertiesLoader();
        String driverPath = pl.getProperty("src/test/resources/param.properties", "chromeDriverPath");
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxDriver = () -> {
        PropertiesLoader pl = new PropertiesLoader();
        String driverPath = pl.getProperty("src/test/resources/param.properties", "firefoxDriverPath");
        System.setProperty("webdriver.gecko.driver", driverPath);
        return new FirefoxDriver();
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriver);
        driverMap.put(DriverType.FIREFOX, firefoxDriver);
    }

    public static final WebDriver getDriver(DriverType type) {
        return driverMap.get(type).get();
    }


}
