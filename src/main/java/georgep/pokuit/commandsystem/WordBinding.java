package georgep.pokuit.commandsystem;

import lombok.Data;

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
public @Data
class WordBinding<T> {

    private final T wordInstance;

    private final WordTypes wordTypes;

    private final String word;

}
