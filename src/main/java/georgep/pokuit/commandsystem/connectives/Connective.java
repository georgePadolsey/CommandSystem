package georgep.pokuit.commandsystem.connectives;

import georgep.pokuit.commandsystem.Word;

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
public interface Connective<T, S, U> extends Word {

    public abstract U perform(T val1, S val2);

}
