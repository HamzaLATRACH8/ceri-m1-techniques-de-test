package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {
        String expectedMessage = "Pokedex error";
        PokedexException exception = new PokedexException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
