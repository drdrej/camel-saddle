package com.touchableheroes.saddle;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ExchangesTest {

    enum Keys {
        TEST_1
    }

    @Test
    public void testCase() {
        Exchange src = Mockito.mock(Exchange.class);

        Exchanges from = Exchanges.from(src);
        Assert.assertNotNull(from);
    }


    @Test
    public void testGetInHeaderCase() {
        Exchange src = Mockito.mock(Exchange.class);
        Message in = Mockito.mock(Message.class);

        Mockito.when(
                src.getIn()
        ).thenReturn( in );

        Mockito.when(
                in.getHeader(
                        Matchers.eq(
                                Keys.TEST_1.name()
                        )
                )
        ).thenReturn( "test done" );

        Assert.assertEquals( "test done",
                Exchanges.from(src)
                         .header(Keys.TEST_1)
        );
    }

}
