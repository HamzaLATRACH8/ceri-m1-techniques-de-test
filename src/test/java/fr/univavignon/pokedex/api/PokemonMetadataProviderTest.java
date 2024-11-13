package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider provider;
    private IPokemonMetadataProvider mockMetadataProvider;

    @Before
    public void setUp() {
        provider = new PokemonMetadataProvider();

        mockMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        try {
            Mockito.when(mockMetadataProvider.getPokemonMetadata(0))
                    .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        try {
            Mockito.when(mockMetadataProvider.getPokemonMetadata(133))
                    .thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        try {
            Mockito.when(mockMetadataProvider.getPokemonMetadata(999))
                    .thenThrow(new PokedexException("Invalid Pokémon index: 999"));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        PokemonMetadata metadata = provider.getPokemonMetadata(0);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadata_Aquali() throws PokedexException {
        PokemonMetadata metadata = provider.getPokemonMetadata(133);
        assertEquals(133, metadata.getIndex());
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        provider.getPokemonMetadata(999);
    }

    @Test
    public void testConstructor_PokemonMetadataProvider() {
        PokemonMetadata metadataBulbizarre = null;
        try {
            metadataBulbizarre = provider.getPokemonMetadata(0);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        PokemonMetadata metadataAquali = null;
        try {
            metadataAquali = provider.getPokemonMetadata(133);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }

        assertNotNull(metadataBulbizarre);
        assertNotNull(metadataAquali);
        assertEquals(0, metadataBulbizarre.getIndex());
        assertEquals("Bulbizarre", metadataBulbizarre.getName());
        assertEquals(133, metadataAquali.getIndex());
        assertEquals("Aquali", metadataAquali.getName());
    }
}
