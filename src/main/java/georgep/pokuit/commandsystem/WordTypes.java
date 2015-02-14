package georgep.pokuit.commandsystem;

import georgep.pokuit.commandsystem.connectives.Connective;

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
public enum WordTypes {

    NOUN(Noun.class),
    ADJECTIVE(Adjective.class),
    VERB(Verb.class),
    CONNECTIVE(Connective.class),
    SUB_VERB(Subverb.class);

    private final Class<? extends Word> clazz;

    WordTypes(Class<? extends Word> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Word> getClazz() {
        return clazz;
    }


}
