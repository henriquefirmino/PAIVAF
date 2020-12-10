package com.paaf.exception;

public class Excecao extends Exception {
    private static final long serialVersionUID = 1L;

    public Excecao(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }
}
