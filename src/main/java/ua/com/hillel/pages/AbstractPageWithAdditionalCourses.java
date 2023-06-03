package ua.com.hillel.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPageWithAdditionalCourses extends AbstractPage {

    public abstract List<String> getAdditionalCourses();

    protected List<String> getAdditionalCourses(ElementsCollection collection, String titleCssSelector) {
        List<String> additionalCoursesNames = new ArrayList<>();
        for (SelenideElement courseTitle : collection) {
            SelenideElement title = courseTitle.$(By.cssSelector(titleCssSelector));
            additionalCoursesNames.add(title.getText());
        }
        return additionalCoursesNames;
    }
}
