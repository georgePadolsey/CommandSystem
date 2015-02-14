package georgep.pokuit.test;

import java.io.Console;
import java.util.Scanner;

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
public class Main {

    public static void main(String[] args) {

        Console console = System.console();
        Scanner in = new Scanner(System.in);

        String line;
        Integer i = 10;

        while(i >= 0) {
            if (console == null) {
             //   System.out.println(":( Console down Console down!");

                line = in.nextLine();


            } else {
                line = console.readLine();
            }

            System.out.println(new CommandHandler().onCommandRaw(line));

            i--;
        }
        in.close();
    }
}
