package com.uniovi.notaneitor.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView {

    static public void fillLoginForm(WebDriver driver, String dni, String password) {
        WebElement dniField = driver.findElement(By.name("username"));
        dniField.click();
        dniField.clear();
        dniField.sendKeys(dni);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        //Pulsar el boton de Alta.
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void login(WebDriver driver, String username, String password, String expectedText){
        //Vamos al formulario de login.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, username, password);
        //Comprobamos que entramos en la página privada
        PO_View.checkElementBy(driver, "text", expectedText);
    }

    public static void logout(WebDriver driver){
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

}
