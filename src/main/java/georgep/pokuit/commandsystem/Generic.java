package georgep.pokuit.commandsystem;

/**
 * todo File Description
 * <p/>
 * <p/>
 * Latest Change:
 * <p/>
 *
 * @author george2
 * @since 13/02/2015
 */
public interface Generic<T, S> {

    public abstract T get(S val);

    public abstract boolean is(S val);

}
