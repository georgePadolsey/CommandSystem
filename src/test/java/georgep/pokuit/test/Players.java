package georgep.pokuit.test;

import java.util.UUID;

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
public class Players {


    public static Player getPlayerExact(String name) {

        return name.equalsIgnoreCase("pokuit") ? new Player("pokuit") : null;
    }

    public static Player getPlayer(UUID uuid) {
        return new Player("pokuit");
    }
}
