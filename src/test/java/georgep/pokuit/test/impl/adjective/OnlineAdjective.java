package georgep.pokuit.test.impl.adjective;

import georgep.pokuit.commandsystem.Adjective;

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
public class OnlineAdjective implements Adjective {
    @Override
    public boolean is(String arg) {
        return arg.equals("online");
    }
}
