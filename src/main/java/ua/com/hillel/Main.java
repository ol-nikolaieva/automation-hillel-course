package ua.com.hillel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ua.com.hillel.pages.HillelHomePage;
import ua.com.hillel.pages.TestingCoursesPage;
import ua.com.hillel.utils.ConfigProvider;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigProvider.BASE_URL);

        HillelHomePage hillelHomePage = PageFactory.initElements(driver, HillelHomePage.class);
        hillelHomePage.goToCourse("Тестування");

        TestingCoursesPage testingCoursesPage = PageFactory.initElements(driver, TestingCoursesPage.class);

        List<String> courseNames = testingCoursesPage.getCourses();
        System.out.println(courseNames);

        List<String> additionalCoursesName = testingCoursesPage.getAdditionalCourses();
        System.out.println(additionalCoursesName);

        List<String> listOfOpportunities = testingCoursesPage.getOpportunities();
        System.out.println(listOfOpportunities);

        testingCoursesPage.goToCategory("Дитячі курси");

        driver.quit();
    }
}

