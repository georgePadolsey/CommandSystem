package georgep.pokuit.test.impl.connectives;

import georgep.pokuit.commandsystem.connectives.Connective;
import georgep.pokuit.test.impl.WordType;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * todo File Description
 * <p/>
 * <p/>
 * Latest Change:
 * <p/>
 *
 * @author George
 * @since 10/02/2015
 */
public @Getter
class Connectives extends WordType<Connective> {

    private final Set<Connective> connectives = new HashSet<>();

    {
        connectives.add(new OrConnective());
        connectives.add(new AndConnective());
    }



    @Override
    public boolean is(String arg) {
        arg = arg.toLowerCase();

        for(Connective connective : connectives) {
            if(connective.is(arg)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Connective get(String arg) {
        arg = arg.toLowerCase();

        for(Connective connective : connectives) {
            if(connective.is(arg)) {
                return connective;
            }
        }

        return null;
    }
}
