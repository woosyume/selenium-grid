package com.failuresharing;

import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.grid.selenium.GridLauncherV3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        GridLauncherV3.main(new String[] { "-port", "4444" });
        GridLauncherV3.main(new String[] { "-role", "node", "-hub",
                "http://localhost:4444/grid/register", "-browser",
                "browserName=chrome", "-port", "4443" });
    
        DesiredCapabilities dc = DesiredCapabilities.chrome();
    
        dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(dc);
    }
    
    @AfterAll
    public static void tearDown() throws InterruptedException {
        driver.quit();
    }  

    @Test
    public void executionTest() {
        driver.get("https://ranking.rakuten.co.jp/");
        System.out.println("---------------");
    }

    @Test
    public void test2() {
        System.out.println("===============");
    }
}
