package georgep.pokuit.commandsystem;

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
public interface Subverb extends Word {

    public abstract Set<Subverb> getSubverbs();

}
