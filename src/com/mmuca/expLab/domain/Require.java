package com.mmuca.expLab.domain;


public class Require {
    public static void that(boolean expression, String message) {
        if (!expression) throw new RequireException(message);
    }

    public static void thatUnreachable(String message) {
        throw new RequireException("Unreachable code: "+message);
    }
}

