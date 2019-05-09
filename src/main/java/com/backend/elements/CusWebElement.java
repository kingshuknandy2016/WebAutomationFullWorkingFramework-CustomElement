package com.backend.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

@ImplementedBy(CusWebElementImpl.class)
public interface CusWebElement extends WebElement, WrapsElement, Locatable {

}
