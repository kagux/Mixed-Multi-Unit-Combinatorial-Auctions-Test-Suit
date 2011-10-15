package com.mmuca.expLab;

import com.mmuca.expLab.domain.Require;
import com.mmuca.expLab.domain.RequireException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class RequireTest {
    @Test
    public void that(){
        try{
            Require.that(false, "message");
            fail("expected an exception");
        }
        catch (RequireException e){
            assertEquals("message",e.getMessage());
        }
    }
    
    @Test
    public void thatCodeIsUnreachable(){
        try{
            Require.thatUnreachable("message");
            fail("expected an exception");
        }
        catch (RuntimeException e){
            assertEquals("Unreachable code: message",e.getMessage());
        }
    }
}
