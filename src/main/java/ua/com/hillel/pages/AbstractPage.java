package ua.com.hillel.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

abstract class AbstractPage {
    public abstract List<String> getCourses();

    protected List<String> getCourses(ElementsCollection collection, String titleCssSelector) {
        List<String> coursesNames = new ArrayList<>();
        for (SelenideElement courseTitle : collection) {
            SelenideElement title = courseTitle.$(By.cssSelector(titleCssSelector));
            coursesNames.add(title.getText());
        }
        return coursesNames;
    }

    public abstract List<String> getOpportunities();

    protected List<String> getOpportunities(ElementsCollection collection, String opportunityHeaderCssSelector) {
        List<String> listOfOpportunities = new ArrayList<>();
        for (SelenideElement opportunity : collection) {
            SelenideElement opportunityHeader = opportunity.$(By.cssSelector(opportunityHeaderCssSelector));
            listOfOpportunities.add(opportunityHeader.getText());
        }
        return listOfOpportunities;
    }

    public abstract void goToCategory(String category);

    protected void goToCategory(String category, ElementsCollection categories) throws NoSuchElementException {
        boolean categoryFound = false;
        for (SelenideElement categoryLink : categories) {
            if (categoryLink.getText().contains(category)) {
                categoryLink.click();
                categoryFound = true;
                break;
            }
        }
        if (!categoryFound) {
            throw new NoSuchElementException("Category not found: " + category);
        }
    }
}
