package com.gp.workshop.junit;

import com.gp.workshop.report.WebFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({WebFactory.class})
public class UnitTest {

    @Mock
    WebDriver driver;

    @Test
    public void testFactory() {
        mockStatic(WebFactory.class);
        when(WebFactory.getDriver(Mockito.any())).thenReturn(driver);
        assertEquals(WebFactory.getDriver(WebFactory.DriverType.CHROME), driver);
    }

}
