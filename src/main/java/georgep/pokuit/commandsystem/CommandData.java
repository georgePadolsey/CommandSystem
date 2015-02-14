package georgep.pokuit.commandsystem;

import lombok.Data;

import java.util.List;

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
public @Data class CommandData {
    private final GCommandSender sender;
    private final String verbUsed;

    private final List<WordBinding<Noun>> nouns;
    private final List<WordBinding<Adjective>> adjectives;
    private final List<String> statementArgs;

    @Deprecated
    private final List<String> arguments;
}
