package com;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintUtilitiessTest {
    PrintUtilities pu;
    @Before
    public void setUp(){
         pu = new PrintUtilities();
    }

    @Test(expected = NegativeArraySizeException.class)
    public void printHorizontalException() throws Exception {
        pu.printHorizontal(-1);
    }
}
