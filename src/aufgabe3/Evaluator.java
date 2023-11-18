/*
 * class Evaluator
 * repl-Schleife: lese von der Konsole eine Zeile und
 * werte sie als arithmetischen Ausdruck aus.
 * Da tokenizer String-Konstante zurückliefert, reicht
 * Gleichheitsprüfung mit == aus (siehe z.B. shift-Methode).
 *
 * Ihr Name: Fabian Wolter
 * Datum: 2023-10-30
 */
package aufgabe3;
import java.util.Scanner;

import static aufgabe3.Tokenizer.*;

/**
 * Klasse zum Auswerten von arithmetischen Ausdrücken.
 */
public class Evaluator {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final Object[] stack = new Object[100];        // Stack
    private static int top = -1;                    // Index des obersten Kellerelements
    private static Object token;                    // Aktuelles Token
    private static Tokenizer tokenizer;                // Zerlegt String-Eingabe in Tokens

    /**
     * Wertet expr als arithmetischen Ausdruck aus.
     *
     * @param expr Arithmetischer Ausdruck als String
     * @return Wert des Ausdrucks oder null, falls der Ausdruck fehlerhaft ist.
     */
    public static Double eval(String expr) {
        // Dollar in leeren Stack ablegen:
        top = -1;
        stack[++top] = DOLLAR;

        // expr in Tokens zerlegen und erstes Token abholen:
        tokenizer = new Tokenizer(expr);
        token = tokenizer.nextToken();

        while (token != null) {
            if (!shift()){
                if(!reduce()){
                    if(accept()){
                        return (double) stack[top];
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private static boolean shift() {
        if (stack[top] == DOLLAR && (token == KL_AUF || isVal(token))) {        // Regel 1 der Parser-Tabelle
            doShift();
            return true;
        } // Ihr Code:
        if (isOp(stack[top]) && (token == KL_AUF || isVal(token))) {            // Regel 2
            doShift();
            return true;
        }
        if (stack[top] == KL_AUF && (token == KL_AUF || isVal(token))) {        // Regel 3
            doShift();
            return true;
        }
        if (isVal(stack[top]) && stack[top - 1] == DOLLAR && isOp(token)) {     // Regel 6
            doShift();
            return true;
        }
        // Regel 7
        if (isVal(stack[top]) && stack[top - 1] == KL_AUF && (token == KL_ZU || isOp(token))) {
            doShift();
            return true;
        }
        if (isValOpVal() && isOp(token)) {
            if (stack[top - 1] == PLUS && token == MULT || token == POWER) {
                doShift();
                return true;
            }
        }
        return false;

    }

    private static boolean isValOpVal() {
        return (isVal(stack[top]) && isOp(stack[top - 1]) && isVal(stack[top - 2]));
    }

    private static void doShift() {
        stack[++top] = token;
        token = tokenizer.nextToken();
    }

    private static boolean isOp(Object o) {
        return (o == PLUS || o == MULT || o == POWER);
    }

    private static boolean isVal(Object o) {
        return o instanceof Double;
    }

    private static boolean reduce() {
        // Regel 4
        if (stack[top] == KL_ZU && isVal(stack[top - 1]) && stack[top - 2] == KL_AUF &&
                (token == KL_ZU || isOp(token) || token == DOLLAR)) {
            doReduceKlValKl();
            return true;
        }
        // Regel 8
        if (isValOpVal() && (token == KL_ZU || token == DOLLAR)) {
            doReduceValOpVal();
            return true;
        }
        // Regel 9
        if (isValOpVal() && isOp(token)) {
            if (!(stack[top - 1] == PLUS && token == MULT || token == POWER)) {
                doReduceValOpVal();
                return true;
            }
        }
        return false;
    }

    private static void doReduceKlValKl() {
        Object val = stack[top - 1];
        top -= 2;
        stack[top] = val;
    }

    private static void doReduceValOpVal() {
        if (stack[top - 1] == PLUS) {
            Object val = (double)stack[top - 2] + (double)stack[top];
            top -= 2;
            stack[top] = val;
        }
        if (stack[top - 1] == MULT) {
            Object val = (double)stack[top - 2] * (double)stack[top];
            top -= 2;
            stack[top] = val;
        }
        if (stack[top - 1] == POWER) {
            Object val = Math.pow((double) stack[top - 2], (double) stack[top]);
            top -= 2;
            stack[top] = val;
        }
    }

    private static boolean accept() {
        return isVal(stack[top]) && stack[top - 1] == DOLLAR && token == DOLLAR;
    }

    /**
     * Liest von der Konsole eine Folge von Zeilen, wertet jede Zeile als
     * Ausdruck aus und gibt seinen Wert aus. (repl = read-evaluate-print-loop).
     */
    public static void repl() {
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_BLUE + ">> ");

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("end")) {
                System.out.println(ANSI_BLUE + "bye!");
                break;
            }
            Double val = eval(line);
            if (val != null) {
                System.out.println(val);
            } else {
                System.out.println("!!! error");
            }
            System.out.print(ANSI_BLUE + ">> ");
        }
    }

    /**
     * Testprogramm.
     *
     * @param args wird nicht benutzt.
     */
    public static void main(String[] args) {
        repl();
    }
}
