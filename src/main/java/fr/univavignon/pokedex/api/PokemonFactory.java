package fr.univavignon.pokedex.api;

/**
 * Concrete implementation of the IPokemonFactory interface.
 *
 * @author fv
 */
public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        int attackIv = (int) (Math.random() * 15);
        int defenseIv = (int) (Math.random() * 15);
        int staminaIv = (int) (Math.random() * 15);

        double iv = (attackIv + defenseIv + staminaIv) / 45.0;

        return new Pokemon(index, "PokemonName", attackIv, defenseIv, staminaIv, cp, hp, dust, candy, iv);
    }

}
