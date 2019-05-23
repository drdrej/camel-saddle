package com.touchableheroes.saddle;

import org.apache.camel.Exchange;

/**
 * Simplify camel fluent lang
 *
 * This Util-Class allows to write more readable Code for Camel.
 */
public class Exchanges {

    private final Exchange ex;

    private Exchanges(Exchange ex) {
        this.ex = ex;
    }

    public static Exchanges from(Exchange src) {
        return new Exchanges(src);
    }

    public final Exchanges withHeader(
            final Enum key,
            final Object val
    ) {
        this.ex.getOut().setHeader(
                key.name(),
                val
        );

        return this;
    }

    public final Exchanges withHeader(
            final String name,
            final Object val
    ) {
        this.ex.getOut().setHeader(
                name,
                val
        );

        return this;
    }

    public final Exchanges passHeader(
            final String name
    ) {
        passHeader(
                this.ex,
                name
        );

        return this;
    }

    public static final void passHeader(
            final Exchange exchange,
            final String name
    ) {
        exchange.getOut()
                .setHeader(
                        name,
                        exchange.getIn().getHeader(name)
                );
    }

    public Exchanges passBody() {
        this.ex.getOut().setBody(
                this.ex.getIn().getBody()
        );

        return this;
    }

    public Exchanges passHeaders() {
        this.ex.getOut().setHeaders(
                this.ex.getIn().getHeaders()
        );

        return this;
    }

    public Exchanges withBody(Object val) {
        this.ex.getOut().setBody(val);

        return this;
    }

    public Exchanges passAll() {
        this.passBody().passHeaders();

        return this;
    }

}

