package com.failuresharing;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.grid.selenium.GridLauncherV3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    private WebDriver driver;

    
    @BeforeEach
    public void setUp() throws MalformedURLException {
        GridLauncherV3.main(new String[] { "-role", "hub", "-port", "4444" });
        WebDriverManager.chromedriver().setup();
        GridLauncherV3.main(new String[] { "-role", "node", "-hub",
                "http://localhost:4444/grid/register", "-browser",
                "browserName=chrome", "-port", "5555" });

        DesiredCapabilities dc = DesiredCapabilities.chrome();

        dc = DesiredCapabilities.chrome();
        // // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
        driver = new RemoteWebDriver(dc);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        driver.quit();
    }  

    @Test
    public void executionTest() {
        driver.get("https://ranking.rakuten.co.jp/");
        System.out.println("---------------");
    }
}
