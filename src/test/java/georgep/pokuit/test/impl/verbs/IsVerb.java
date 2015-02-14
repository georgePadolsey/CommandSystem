package georgep.pokuit.test.impl.verbs;

import georgep.pokuit.commandsystem.*;
import georgep.pokuit.test.impl.Propertable;
import georgep.pokuit.test.impl.adjective.OnlineAdjective;
import georgep.pokuit.test.impl.nouns.PlayerNoun;
import lombok.Data;

import java.util.*;

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
public class IsVerb implements Verb<Boolean> {

    private static List<String> synonyms = new LinkedList<>();

    private static Set<Adjective> adjectives = new HashSet<>();

    private static Set<Class<? extends Noun>> nouns = new HashSet<>();

    static {
        // Synonyms:
        synonyms.add("is");

        // Adjectives:
        adjectives.add(new OnlineAdjective());

        // Nouns
        nouns.add(PlayerNoun.class);

    }

    @Override
    public VerbData evaluateResults(CommandData data) throws CommandException {
        Boolean result = false;
        WordBinding noun = null;
        String key = null;

        if(data.getNouns().size() != 0) {

            noun = data.getNouns().get(0);
            key = data.getAdjectives().get(0).getWord();


            Noun nounWordInstance = (Noun) noun.getWordInstance();

            Object prop = nounWordInstance.get(noun.getWord());

            if (prop instanceof Propertable) {
                Propertable propertable = (Propertable) prop;

                try {
                    result = propertable.queryProperties().getBoolean(key);
                } catch (Exception ignored) {
                }
            }
        }

        return new IsVerbData(result, String.format("%s is %s%s", noun != null ? noun.getWord() : "<undefined>", result || noun == null ? "" : "not " , key != null ? key : "<undefined>"));
    }

    @Override
    public Set<Adjective> getAdjectives() {
        return adjectives;
    }

    @Override
    public Set<Class<? extends Noun>> getNouns() {
        return nouns;
    }

    @Override
    public Set<Subverb> getSubverbs() {
        return null;
    }


    @Override
    public boolean is(String arg) {
        arg = arg.toLowerCase().trim();

        return synonyms.contains(arg);
    }

    private @Data
    class IsVerbData extends VerbData<Boolean> {

        private final Boolean rawData;
        private final String prettyData;


        @Override
        public String getPrettyData() {
            return prettyData;
        }
    }
}
