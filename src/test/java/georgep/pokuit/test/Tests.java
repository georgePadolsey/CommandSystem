package georgep.pokuit.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * todo File Description
 * <p>
 * <p>
 * Latest Change:
 * <p>
 *
 * @author george2
 * @since 14/02/2015
 */
public class Tests {

    @Test
    public void absIsPlayerTest() {
        assertEquals("failure - Is player online test", true, new CommandHandler().onCommandRaw("is pokuit online"));

        assertEquals("failure - Is player online test", false, new CommandHandler().onCommandRaw("is cake online"));
        assertEquals("failure - Is player online test", false, new CommandHandler().onCommandRaw("is lemon online"));
        assertEquals("failure - Is player online test", true, new CommandHandler().onCommandRaw("pokuit is online"));
    }
}
