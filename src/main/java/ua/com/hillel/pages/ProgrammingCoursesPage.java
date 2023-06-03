package ua.com.hillel.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class ProgrammingCoursesPage extends AbstractPageWithAdditionalCourses {

    private ElementsCollection programmingCourses = $$(".block-profession_group:first-of-type li");
    private ElementsCollection additionalProgrammingCourses = $$(".li.profession_item.-active > div > div:nth-child(2)");
    private ElementsCollection opportunities = $$("li.opportunities_item:not(:first-child)");
    private ElementsCollection categories = $$("ul.categories_list li a");
    private ElementsCollection programmingLanguages = $$("ul.subcategories_list li");

    private String titleCssSelector = "p.profession-bar_title";
    private String additionalCoursesCssSelector = "p.block-profession_subtitle";
    private String opportunityHeaderCssSelector = "p.opportunity-item_title.p-l";

    public List<String> getProgrammingLanguages() {
        List<String> coursesNames = new ArrayList<>();
        for (SelenideElement courseTitle : programmingLanguages) {
            SelenideElement title = courseTitle.$("ul.subcategories_list li button");
            coursesNames.add(title.getText());
        }
        return coursesNames;
    }

    @Override
    public List<String> getCourses() {
        return getCourses(programmingCourses, titleCssSelector);
    }

    @Override
    public List<String> getAdditionalCourses() {
        return getAdditionalCourses(additionalProgrammingCourses, additionalCoursesCssSelector);
    }

    @Override
    public List<String> getOpportunities() {
        return getOpportunities(opportunities, opportunityHeaderCssSelector);
    }

    @Override
    public void goToCategory(String category) {
        goToCategory(category, categories);
    }
}

