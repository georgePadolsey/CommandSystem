package georgep.pokuit.test.impl;

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
public abstract class WordType<T> {

    public abstract boolean is(String arg);

    public abstract T get(String arg);
}
