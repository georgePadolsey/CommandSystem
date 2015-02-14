package georgep.pokuit.commandsystem;


import georgep.pokuit.utils.Prettify;

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
public abstract class VerbData<T> {

    public abstract T getRawData();

    public String getPrettyData() {
        return ">>>"+ Prettify.prettifyValue(getRawData());
    }

    @Override
    public String toString() {
        return getPrettyData();
    }
}
