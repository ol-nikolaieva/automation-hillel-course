package ua.com.hillel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ua.com.hillel.utils.ConfigProvider;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(ConfigProvider.BASE_URL);

        WebElement programmingCourseButton = driver.findElement(By.xpath("//a[contains(@href, 'programming')]"));
        programmingCourseButton.click();

        WebElement frontEndCourseButton = driver.findElement(By.xpath("//li[@class='block-profession_item']/a[contains(@href, 'front-end-basic')]"));
        frontEndCourseButton.click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(30))
                .withTimeout(Duration.ofSeconds(10))
                .ignoreAll(List.of(NoSuchElementException.class, ElementClickInterceptedException.class));


        ((JavascriptExecutor) driver).executeScript("window.scrollTo" +
                  driver.findElement(By.xpath("//section[@class='section -profession']")).getLocation());

        WebElement coachList = wait.until(d -> {
            return driver.findElement(By.xpath("//*[@id='coachesSection']/div/div/ul"));
        });

        List<WebElement> coaches = coachList.findElements(By.xpath("//li[@class='coach-list_item']"));
        WebElement coachesShowAllButton = driver.findElement(By.id("coachesShowAllButton"));


        wait.until(d -> {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100)");
                return coachesShowAllButton.isEnabled();
        });

        coachesShowAllButton.click();

        List<String> coachesName = coaches.stream()
                .map(element -> element.findElement(By.cssSelector(".coach-card_name")).getText())
                .toList();

        List<String> mutableCoachesName = new ArrayList<>(coachesName);
        Collections.sort(mutableCoachesName);

        System.out.println(mutableCoachesName);

        driver.quit();
    }
}

