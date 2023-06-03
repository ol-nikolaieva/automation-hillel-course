package ua.com.hillel.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class DesignCoursesPage extends AbstractPage {



    private ElementsCollection designCourses = $$(".block-profession_group:first-of-type li");
    private ElementsCollection opportunities = $$("li.opportunities_item:not(:first-child)");
    private ElementsCollection categories = $$("ul.categories_list li a");

    private String titleCssSelector = "p.profession-bar_title";
    private String opportunityHeaderCssSelector = "p.opportunity-item_title.p-l";

    @Override
    public List<String> getCourses() {
        return getCourses(designCourses, titleCssSelector);
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
