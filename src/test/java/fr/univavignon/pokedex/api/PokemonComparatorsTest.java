package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokemonComparatorsTest {

    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @Before
    public void setUp() {
        pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void testCompareByName() {
        int result = PokemonComparators.NAME.compare(pokemon1, pokemon2);
        assertTrue("Comparing by name failed", result > 0); // Bulbizarre > Aquali
    }

    @Test
    public void testCompareByIndex() {
        int result = PokemonComparators.INDEX.compare(pokemon1, pokemon2);
        assertTrue("Comparing by index failed", result < 0); // 1 < 2
    }

    @Test
    public void testCompareByCp() {
        int result = PokemonComparators.CP.compare(pokemon1, pokemon2);
        assertTrue("Comparing by CP failed", result < 0); // 613 < 2729
    }
}
