package georgep.pokuit.test.impl.nouns;

import georgep.pokuit.commandsystem.Adjective;
import georgep.pokuit.commandsystem.Noun;
import georgep.pokuit.test.Player;
import georgep.pokuit.test.Players;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * todo File Description
 * <p>
 * <p>
 * Latest Change:
 * <p>
 *
 * @author George
 * @since 12/02/2015
 */
public class PlayerNoun implements Noun<Player> {

    Pattern uuidRegex = Pattern.compile("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}");

    @Override
    public Set<Adjective> getAdjectives() {
        return null;
    }

    @Override
    public List<String> getTabCompleteFor(String arg) {
        return null;
    }

    @Override
    public boolean is(String s) {
        return Players.getPlayerExact(s.toLowerCase().trim()) != null || (uuidRegex.matcher(s).matches() && Players.getPlayer(UUID.fromString(s)) != null);
    }

    @Override
    public Player get(String s) {
        return Players.getPlayerExact(s.toLowerCase().trim());
    }

}
