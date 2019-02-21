package infrastructure.persistence.sqlite;

import java.util.List;

import domain.move.Move;
import domain.move.MoveRepository;
import domain.move.MovesCollection;

import static poketext.Opcions.lang;

public class MoveRepositorySQLite extends SQLiteRepository implements MoveRepository {

    public MovesCollection findByCriteria(String pokemon_id, String name, String type) {
        List<String[]> rowset = executeQuery("select distinct(m.id), n.name, t.name as type, d.identifier, m.power, m.accuracy, m.pp, f.flavor_text\n"
                + "from pokemon_moves p, move_names n, moves m, type_names t, move_flavor_text f, move_damage_classes d\n"
                + "where m.id = p.move_id\n"
                + "and m.id = n.move_id\n"
                + "and t.type_id = m.type_id\n"
                + "and m.id = f.move_id\n"
                + "and p.version_group_id = 16\n"
                + "and m.damage_class_id = d.id\n"
                + "and n.local_language_id = " + lang + "\n"
                + "and t.local_language_id = " + lang + "\n"
                + "and f.language_id = " + lang + "\n"
                + "and p.pokemon_id like '%" + pokemon_id + "%'\n"
                + "and f.version_group_id = 16\n"
                + "and n.name like '%" + name + "%'\n"
                + "and t.name like '%" + type + "%'\n"
                + "order by m.id");

        return buildMoves(rowset);
    }

    private MovesCollection buildMoves(List<String[]> rowset) {
        MovesCollection moves = new MovesCollection();
        for (int i = 0; i < rowset.size(); i++) {
            Move move = new Move(rowset.get(i));
            moves.add(move);
        }

        return moves;
    }

}
