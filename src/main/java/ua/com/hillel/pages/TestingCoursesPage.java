package ua.com.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TestingCoursesPage {

    @FindBy(css = ".block-profession_group:first-of-type li")
    private List <WebElement> testCourses;

    @FindBy(css = ".block-profession_group:last-of-type li")
    private List <WebElement> additionalTestCourses;

    @FindBy(css = "li.opportunities_item:not(:first-child)")
    private List<WebElement> opportunities;

    @FindBy(css = "ul.categories_list li a")
    private List<WebElement> categories;


    public List<String> getCourses () {
        List <String> coursesNames = new ArrayList<>();
        for (WebElement courseTitle : testCourses) {
            WebElement title = courseTitle.findElement(By.cssSelector("p.profession-bar_title"));
            coursesNames.add(title.getText());
        }
        return coursesNames;
    }

    public List<String> getAdditionalCourses() {
        List <String> additionalCoursesNames = new ArrayList<>();
        for (WebElement courseTitle : additionalTestCourses) {
            WebElement title = courseTitle.findElement(By.cssSelector("p.profession-bar_title"));
            additionalCoursesNames.add((title.getText()));
        }
        return additionalCoursesNames;
    }

    public List<String> getOpportunities() {
        List<String> listOfOpportunities = new ArrayList<>();
        for (WebElement opportunity: opportunities) {
            WebElement opportunityHeader = opportunity.findElement(By.cssSelector("p.opportunity-item_title.p-l"));
            listOfOpportunities.add((opportunityHeader.getText()));
        }
        return listOfOpportunities;
    }


    public void goToCategory(String category) throws NoSuchElementException {
        boolean categoryFound = false;
        for (WebElement categoryLink : categories) {
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
