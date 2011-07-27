package fr.java.freelance.fluentlenium.core;

import fr.java.freelance.fluentlenium.action.FillConstructor;
import fr.java.freelance.fluentlenium.action.FluentDefaultActions;
import fr.java.freelance.fluentlenium.domain.FluentList;
import fr.java.freelance.fluentlenium.domain.FluentWebElement;
import fr.java.freelance.fluentlenium.filter.Filter;
import fr.java.freelance.fluentlenium.search.Search;
import fr.java.freelance.fluentlenium.search.SearchActions;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Util Class which offers some shortcut to webdriver methods
 */
public class Fluent implements SearchActions {
    private WebDriver driver;
    private Search search;

    public Fluent(WebDriver driver) {
        this.driver = driver;
        this.search = new Search(driver);
    }

    public Fluent() {
    }

    protected void setDriver(WebDriver driver) {
        this.driver = driver;
        this.search = new Search(driver);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Return the title of the page
     *
     * @return
     */
    protected String title() {
        return driver.getTitle();
    }

    /**
     * Return the url of the page
     *
     * @return
     */
    protected String url() {
        return driver.getCurrentUrl();
    }


    /**
     * Central methods to find elements on the page. Can provide some filters. Able to use css1, css2, css3, see WebDriver  restrictions
     *
     * @param name
     * @param filters
     * @return
     */
    public FluentList $(String name, final Filter... filters) {
        return search.find(name, filters);
    }


    /**
     * Central methods a find element on the page, the number indicat the index of the desired element on the list. Can provide some filters. Able to use css1, css2, css3, see WebDriver  restrictions
     *
     * @param name
     * @param filters
     * @return
     */
    public FluentWebElement $(String name, Integer number, final Filter... filters) {
        return search.find(name, number, filters);
    }


    /**
     * return the lists corresponding to the cssSelector with it filters
     *
     * @param name
     * @param filters
     * @return
     */
    public FluentList find(String name, final Filter... filters) {
        return search.find(name, filters);
    }

    /**
     * Return the elements at the numner position into the the lists corresponding to the cssSelector with it filters
     *
     * @param name
     * @param number
     * @param filters
     * @return
     */
    public FluentWebElement find(String name, Integer number, final Filter... filters) {
        return search.find(name, number, filters);
    }

    /**
     * Return the first elements corresponding to the name and the filters
     *
     * @param name
     * @param filters
     * @return
     */
    public FluentWebElement findFirst(String name, final Filter... filters) {
        return search.findFirst(name, filters);
    }

    /**
     * Construct a FillConstructor in order to allow easy fill
     * Be careful - only the visible elements are filled
     *
     * @param cssSelector
     */
    public FillConstructor fill(String cssSelector, Filter... filters) {
        return new FillConstructor(cssSelector, getDriver(), filters);
    }

    /**
     * Construct a FillConstructor in order to allow easy fill
     * Be careful - only the visible elements are filled
     *
     * @param list
     */
    public FillConstructor fill(FluentDefaultActions list, Filter... filters) {
        return new FillConstructor(list, getDriver(), filters);
    }

    /**
     * click all elements that are in cssSelector with its filters
     * Be careful - only the visible elements are clicked
     *
     * @param cssSelector
     */
    public void click(String cssSelector, Filter... filters) {
        $(cssSelector, filters).click();
    }

    /**
     * Submit all elements that are in cssSelector with its filters
     * Be careful - only the visible elements are cleared
     *
     * @param cssSelector
     */
    public void clear(String cssSelector, Filter... filters) {
        $(cssSelector, filters).clear();
    }

    /**
     * Submit all elements that are in cssSelector with its filters
     * Be careful - only the visible elements are submitted
     *
     * @param cssSelector
     */
    public void submit(String cssSelector, Filter... filters) {
        $(cssSelector, filters).submit();
    }

    /**
     * Submit all elements that are in cssSelector with its filters
     * Be careful - only the visible elements are submitted
     * //TODO UTILITY ? Deprecated ?
     *
     * @param cssSelector
     */
    public List<String> text(String cssSelector, Filter... filters) {
        return $(cssSelector, filters).getTexts();
    }

    /**
     * Value all elements that are in cssSelector with its filters
     * Be careful - only the visible elements are returned
     * //TODO UTILITY ? Deprecated ?
     *
     * @param cssSelector
     */
    public List<String> value(String cssSelector, Filter... filters) {
        return $(cssSelector, filters).getValues();
    }


    /**
     * click all elements that are in the list
     * Be careful - only the visible elements are clicked
     *
     * @param fluentObject
     */
    public void click(FluentDefaultActions fluentObject) {
        fluentObject.click();
    }

    /**
     * Submit all elements that are in the list
     * Be careful - only the visible elements are cleared
     *
     * @param fluentObject
     */
    public void clear(FluentDefaultActions fluentObject) {
        fluentObject.clear();
    }

    /**
     * Submit all elements that are in the list
     * Be careful - only the visible elements are submitted
     *
     * @param fluentObject
     */
    public void submit(FluentDefaultActions fluentObject) {
        fluentObject.submit();
    }


}