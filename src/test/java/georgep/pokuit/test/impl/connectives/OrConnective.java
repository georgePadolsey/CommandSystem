package georgep.pokuit.test.impl.connectives;

import georgep.pokuit.commandsystem.connectives.Connective;

import java.util.Arrays;
import java.util.List;

/**
 * todo File Description
 * <p>
 * <p>
 * Latest Change:
 * <p>
 *
 * @author George
 * @since 09/02/2015
 */
public class OrConnective implements Connective<Boolean, Boolean, Boolean> {

    private static List<String> synonyms = Arrays.asList(
            "or",
            "either",
            "conversely"
    );

    private static List<String> antonyms = Arrays.asList(
            "neither",
            "nor"
    );

    @Override
    public Boolean perform(Boolean val1, Boolean val2) {
        return val1 || val2;
    }

    @Override
    public boolean is(String arg) {
        arg = arg.toLowerCase().trim();

        return antonyms.contains(arg) || synonyms.contains(arg);
    }
}
