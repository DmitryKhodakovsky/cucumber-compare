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
package com.epam.cucumber.compare.qa.acceptance.tests.cucumber1.w3schools.stepsDef;

import com.epam.cucumber.compare.qa.common.gui.services.pages.HomePageObject;
import com.epam.cucumber.compare.qa.common.gui.services.webdriver.WrappedWebdriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import com.epam.cucumber.compare.qa.acceptance.tests.cucumber1.w3schools.configuration.AppConfig;

@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext
public class AbstractStepsDef {

    @Autowired
    @Lazy
    public WrappedWebdriver driver;

    @Autowired
    @Lazy
    protected HomePageObject homePage;

}
