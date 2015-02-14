package georgep.pokuit.test;

import georgep.pokuit.commandsystem.GCommandSender;
import georgep.pokuit.test.impl.IsProperties;
import georgep.pokuit.test.impl.Propertable;
import lombok.Data;

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
public @Data
class Player implements Propertable, GCommandSender {

    private final String name;

    @Override
    public IsProperties queryProperties() {

        IsProperties prop = new IsProperties();

        prop.setProperty("online", true);

        return prop;

    }
}
