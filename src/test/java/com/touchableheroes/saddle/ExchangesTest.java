package com.touchableheroes.saddle;

import org.apache.camel.Exchange;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ExchangesTest {

    @Test
    public void testCase() {
        Exchange src = Mockito.mock(Exchange.class);

        Exchanges from = Exchanges.from(src);
        Assert.assertNotNull(from);
    }

}
