package georgep.pokuit.test.impl.verbs;

import georgep.pokuit.commandsystem.Verb;
import georgep.pokuit.test.impl.WordType;
import lombok.Getter;

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
 * @since 10/02/2015
 */
public
@Getter
class Verbs extends WordType<Verb> {

    private final Set<Verb> verbs = new HashSet<>();

    {
        verbs.add(new IsVerb());
    }

    @Override
    public boolean is(String arg) {
        arg = arg.toLowerCase();

        for(Verb verb : verbs) {
            if(verb.is(arg)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Verb get(String arg) {
        arg = arg.toLowerCase();

        for(Verb verb : verbs) {
            if(verb.is(arg)) {
                return verb;
            }
        }

        return null;
    }
}
