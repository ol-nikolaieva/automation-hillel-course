package ua.com.hillel;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ua.com.hillel.pages.HillelHomePage;
import ua.com.hillel.pages.TestingCoursesPage;
import ua.com.hillel.utils.ConfigProvider;

import static com.codeborne.selenide.Selenide.*;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Configuration.baseUrl = ConfigProvider.BASE_URL;
       open("/");
        HillelHomePage hillelHomePage = new HillelHomePage();
        hillelHomePage.goToCourse("Тестування");

        TestingCoursesPage testingCoursesPage = new TestingCoursesPage();

        List<String> courseNames = testingCoursesPage.getCourses();
        System.out.println(courseNames);

        List<String> additionalCoursesName = testingCoursesPage.getAdditionalCourses();
        System.out.println(additionalCoursesName);

        closeWebDriver();
    }
}

