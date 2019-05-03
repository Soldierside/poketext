package infrastructure.cercador;

import java.io.IOException;

import application.pokemon.GetPokemons.GetPokemonsService;
import infrastructure.persistence.SQLite.PokemonRepositorySQLite;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.presentation.reader.StreamReader;
import infrastructure.presentation.transformer.matrix.PokemonAssemblerMatrix;

public class Pokemons {

    public static void cercarPokemons() {
        String[] pokedex, s;
        String filter_type = "";
        String filter_name = "";
        boolean sortir = false;

        try {
            pokedex = Pokedex.cercarPokedex();

            do {

                GetPokemonsService service = new GetPokemonsService(new PokemonRepositorySQLite(), new PokemonAssemblerMatrix());
                String[][] pokemons = service.execute(Integer.parseInt(pokedex[0]), filter_name, filter_type);

                // Mostrar per pantalla els pokèmons
                System.out.printf("%n%nPokèdex: %s%n", pokedex[1]);
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                MatrixPrinter.print(pokemons);
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                System.out.printf("Pokèdex: %s%n%n", pokedex[1]);

                // Opcions del menú
                System.out.printf("%nCERCADOR: POKÈDEX%n");
                System.out.println("P. Cambiar Pokèdex");
                System.out.println("N. Filtrar per nom");
                System.out.println("T. Filtrar per tipus");
                System.out.println("E. Eliminar filtre");
                System.out.println("Q. Sortir");
                s = StreamReader.read().split(" ");

                // Seleccions del menú
                if ((s[0].equalsIgnoreCase("p")) && (s.length == 1)) {
                    pokedex = Pokedex.cercarPokedex();
                } else if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                    filter_name = s[1];
                } else if ((s[0].equalsIgnoreCase("t")) && (s.length == 2)) {
                    filter_type = s[1];
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 2)) {
                    if (s[1].equalsIgnoreCase("n")) {
                        filter_name = "";
                    } else if (s[1].equalsIgnoreCase("t")) {
                        filter_type = "";
                    }
                } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                    sortir = true;
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } while (!sortir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
