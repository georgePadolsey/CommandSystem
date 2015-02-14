package georgep.pokuit.test.impl.nouns;

import georgep.pokuit.commandsystem.Noun;
import georgep.pokuit.test.impl.WordType;

import java.util.HashSet;
import java.util.Set;

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
public class Nouns extends WordType<Noun> {

    private final Set<Noun> nouns = new HashSet<>();

    {
        nouns.add(new PlayerNoun());
    }

    @Override
    public boolean is(String arg) {
        arg = arg.toLowerCase();

        for(Noun noun : nouns) {
            if(noun.is(arg)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Noun get(String arg) {
        arg = arg.toLowerCase();

        for(Noun noun : nouns) {
            if(noun.is(arg)) {
                return noun;
            }
        }

        return null;
    }
}
