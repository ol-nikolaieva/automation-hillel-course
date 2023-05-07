package ua.com.hillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class HillelHomePage {
    @FindBy(css = "a.block-course-cats_link.course-cat-bar")
    private List<WebElement> courses;


    public void goToCourse(String course) throws NoSuchElementException {
        boolean courseFound = false;
        for (WebElement categoryLink : courses) {
            if (categoryLink.getText().contains(course)) {
                categoryLink.click();
                courseFound = true;
                break;
            }
        }
        if (!courseFound) {
            throw new NoSuchElementException("Course not found: " + course);
        }
    }
}