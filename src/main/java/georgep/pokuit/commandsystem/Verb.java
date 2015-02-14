package georgep.pokuit.commandsystem;

import java.util.Set;

/**
 * todo File Description
 * <p/>
 * <p/>
 * Latest Change:
 * <p/>
 *
 * @author George
 * @since 09/02/2015
 */
public interface Verb<T> extends Subverb {

    public abstract VerbData evaluateResults(CommandData data) throws CommandException;

    public abstract Set<Adjective> getAdjectives();

    public abstract Set<Class<? extends Noun>> getNouns();

}
