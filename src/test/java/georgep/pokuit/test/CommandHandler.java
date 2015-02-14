package georgep.pokuit.test;

import georgep.pokuit.commandsystem.*;
import georgep.pokuit.commandsystem.connectives.Connective;
import georgep.pokuit.test.Player;
import georgep.pokuit.test.impl.connectives.Connectives;
import georgep.pokuit.test.impl.nouns.Nouns;
import georgep.pokuit.test.impl.verbs.Verbs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
public class CommandHandler {

    private final Nouns nouns = new Nouns();
    private final Verbs verbs = new Verbs();
    private final Connectives connectives = new Connectives();

    public List<WordBinding> commandData = new LinkedList<>();

    public String onCommand(String command) {

        command = command.toLowerCase();

        if (command.length() <= 0) {
            return null;
        }

        try {
            return run(command).getPrettyData();
        } catch (CommandException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Object onCommandRaw(String command) {
        command = command.toLowerCase();

        if (command.length() <= 0) {
            return null;
        }

        try {
            return run(command).getRawData();
        } catch (CommandException e) {
            e.printStackTrace();
        }

        return null;
    }

    public VerbData run(String command) throws CommandException {


        List<String> args = Arrays.asList(command.split(" "));


        WordTypes type;
        for (String arg : args) {
            type = getType(arg);
            commandData.add(new WordBinding<>(getWord(arg), type, arg));
        }


        System.out.println(commandData.toString());

        // assume commandWords is whole statement
        WordBinding<Verb> b = getVerbs(commandData).get(0);

        return b.getWordInstance().evaluateResults(new CommandData(new Player("George"), b.getWord(), getNouns(commandData), getAdjectives(commandData), args, args));

    }

    public List<WordBinding<Noun>> getNouns(List<WordBinding> commandData) {
        //noinspection unchecked
        return commandData.stream().filter(w -> w.getWordTypes() == WordTypes.NOUN).map(w -> (WordBinding<Noun>) w).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<WordBinding<Adjective>> getAdjectives(List<WordBinding> commandData) {
        //noinspection unchecked
        return commandData.stream().filter(w -> w.getWordTypes() == WordTypes.ADJECTIVE).map(w -> (WordBinding<Adjective>) w).collect(Collectors.toCollection(LinkedList::new));
    }

    public List<WordBinding<Verb>> getVerbs(List<WordBinding> commandData) {
        //noinspection unchecked
        return commandData.stream().filter(w -> w.getWordTypes() == WordTypes.VERB).map(w -> (WordBinding<Verb>) w).collect(Collectors.toCollection(LinkedList::new));
    }

    public Word getWord(String arg) {

        WordTypes type = getType(arg);

        if (type == null) {
            return null;
        }

        switch (type) {
            case VERB:
                return getVerb(arg);
            case CONNECTIVE:
                return getConnective(arg);
            case NOUN:
                return getNoun(arg);
            default:
                return null;
        }

    }

    public Verb getVerb(String arg) {
        return verbs.get(arg);
    }

    public Noun getNoun(String arg) {
        return nouns.get(arg);
    }

    public Connective getConnective(String arg) {
        return connectives.get(arg);
    }


    public WordTypes getType(String arg) {

        // First check if verb

        if (verbs.is(arg)) {
            return WordTypes.VERB;
        }


        if (connectives.is(arg)) {
            return WordTypes.CONNECTIVE;
        }

        if (nouns.is(arg)) {
            return WordTypes.NOUN;
        }

        return WordTypes.ADJECTIVE;
    }
}
