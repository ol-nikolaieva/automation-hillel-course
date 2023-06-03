package ua.com.hillel.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$$;

public class HillelHomePage  {
    private ElementsCollection courses = $$("a.block-course-cats_link.course-cat-bar");

    public HillelHomePage() {
        super();
    }

    public void goToCourse(String course) throws NoSuchElementException {
        boolean courseFound = false;
        for (SelenideElement categoryLink : courses) {
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