package com.epam.cucumber.compare.qa.common.gui.services.pages;
/*
 * Copyright 2002 - 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.epam.cucumber.compare.qa.common.gui.annotations.PageObject;
import com.epam.cucumber.compare.qa.common.gui.enums.CustomersTable;
import com.epam.cucumber.compare.qa.common.gui.model.Customers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PageObject
public class HomePageObject extends AbstractPageObject {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${site.url:localhost}")
    protected String siteUrl;

    public void open() {
        LOG.info("Open HTML HOME page");
        driver.get(siteUrl);

    }

    public void changeLang() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"gh-eb-Geo\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"gh-eb-Geo-a-en\"]")).click();
    }

    public void clickLink(String linkName) {
        driver.findElement(By.linkText(linkName)).click();
    }

    public List<String> getColumnNames() {
        return driver.findElements(By.xpath("//table[@id=\"customers\"]//th"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getColumnValues(String columnName) {
        return driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/td[" + CustomersTable.fromName(columnName).getIndex() + "]"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }

    public int getRowCount() {
        return driver.findElements(By.xpath("//table[@id=\"customers\"]//tr")).size() - 1;
    }

    public List<Customers> getCustomers() {
        List<Customers> results = new ArrayList<>();
        for (int i = 2; i <= getRowCount() + 1; i++) {
            results.add(Customers.builder()
                    .company(driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[" + i + "]/td[1]")).getText())
                    .contact(driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[" + i + "]/td[2]")).getText())
                    .country(driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[" + i + "]/td[3]")).getText())
                    .build());
        }
        return results;
    }
}
