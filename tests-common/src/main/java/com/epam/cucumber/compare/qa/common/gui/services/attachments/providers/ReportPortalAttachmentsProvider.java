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
package com.epam.cucumber.compare.qa.common.gui.services.attachments.providers;

import com.epam.cucumber.compare.qa.common.gui.services.webdriver.WrappedWebdriver;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@Lazy
public class ReportPortalAttachmentsProvider implements AttachmentsProvider {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private WrappedWebdriver driver;

    @Override
    public String attachPageTitle() {
        return "true";
    }

    @Override
    public String attachText(String nameOfAttachment, String textOfAttachment) {
        return null;
    }

    @Override
    public void attachScreenshot() {
        LOG.debug("Attach screenshot to the RP report");
        try (InputStream is = new ByteArrayInputStream(driver.takeScreenshot())) {
            Allure.addAttachment("Page Screenshot", is);
        } catch (IOException e) {
            LOG.debug("Screenshot taking failed");
        }
    }

    @Override
    public void attachScreenshot(String nameOfScreenshot) {
        LOG.debug("Attach screenshot to the RP report");
        try (InputStream is = new ByteArrayInputStream(driver.takeScreenshot())) {
            Allure.addAttachment("Page Screenshot", is);
        } catch (IOException e) {
            LOG.debug("Screenshot taking failed");
        }
    }
}
