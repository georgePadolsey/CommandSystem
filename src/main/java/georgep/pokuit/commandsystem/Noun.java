package georgep.pokuit.commandsystem;

import java.util.List;
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
public interface Noun<T> extends Word {

    public abstract Set<Adjective> getAdjectives();
    public abstract List<String> getTabCompleteFor(String arg);
    public abstract T get(String s);

}
