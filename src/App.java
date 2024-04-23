import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            int problemNumber = Integer.parseInt(line);
            System.out.println(problemNumber);
            if (problemNumber == 1) {
                writer.write(1 + "\n");
                problem1(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 2) {
                writer.write(2 + "\n");
                problem2(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 3) {
                writer.write(3 + "\n");
                problem3(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 4) {
                writer.write(4 + "\n");
                problem4(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 5) {
                writer.write(5 + "\n");
                problem5(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 6) {
                writer.write(6 + "\n");
                problem6(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 7) {
                writer.write(7 + "\n");
                problem7(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 8) {
                writer.write(8 + "\n");
                problem8(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 9) {
                writer.write(9 + "\n");
                problem9(reader, writer);
                writer.write("x\n");
            } else if (problemNumber == 10) {
                writer.write(10 + "\n");
                problem10(reader, writer);
                writer.write("x\n");
            }
        }

        /// من غير السطرين دول مش هيكتب في الفايل
        reader.close();
        writer.close();
    }

    ////////// PROBLRM 1
    public static void problem1(BufferedReader reader, BufferedWriter writer) throws IOException {

        Dfa Problem1 = new Dfa(
                new String[] { "q0", "q1", "q2" },
                new String[] { "a", "b" },
                new String[] { "q0", "q1" },
                new Transition[] {
                        new Transition("q0", "a", "q0"),
                        new Transition("q0", "b", "q1"),
                        new Transition("q1", "b", "q1"),
                        new Transition("q1", "a", "q2"),
                        new Transition("q2", "a", "q2"),
                        new Transition("q2", "b", "q2"),

                },
                "q0");
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            Problem1.input(line);
            if (Problem1.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            Problem1.reset();
        }
    }

    // Problem1.input("ab");
    // Problem1.input("ba");
    // Problem1.input("aba");
    // Problem1.input("bbb");
    // System.out.println(Problem1.isAccepting());

    public static void problem2(BufferedReader reader, BufferedWriter writer) throws IOException {

        Dfa problem2 = new Dfa(
                new String[] { "q0", "q1", "q2", "q3", "q4"},
                new String[] { "0", "1" },
                new String[] { "q3" },
                new Transition[] {
                        new Transition("q0", "0", "q1"),
                        new Transition("q0", "1", "q3"),
                        new Transition("q1", "0", "q2"),
                        new Transition("q1", "1", "q4"),
                        new Transition("q2", "0", "q1"),
                        new Transition("q2", "1", "q3"),
                        new Transition("q3", "0", "q1"),
                        new Transition("q3", "1", "q4"),
                        new Transition("q4", "0", "q4"),
                        new Transition("q4", "1", "q4"),
                },
                "q0"
        );

        String line;
        while (!(line = reader.readLine()).equals("end")) {
            problem2.input(line);
            if (problem2.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            problem2.reset();
        }

    }

    ///////// PROBLRM 3
    public static void problem3(BufferedReader reader, BufferedWriter writer) throws IOException {

        Dfa Problem3 = new Dfa(
                new String[] { "q0", "q1", "q2" },
                new String[] { "x", "y" },
                new String[] { "q1" },
                new Transition[] {
                        new Transition("q0", "y", "q0"),
                        new Transition("q0", "x", "q1"),
                        new Transition("q1", "y", "q1"),
                        new Transition("q1", "x", "q2"),
                        new Transition("q2", "y", "q2"),
                        new Transition("q2", "x", "q1"),

                },
                "q0");
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            Problem3.input(line);
            if (Problem3.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            Problem3.reset();
        }
    }

    // Problem3.input("x");
    // Problem3.input("xyxyxyy");
    // Problem3.input("yyy");
    // Problem3.input("yxxxy");
    // System.out.println(Problem3.isAccepting());

    public static void problem4(BufferedReader reader, BufferedWriter writer) throws IOException {

        Dfa problem4 = new Dfa(
                new String[] { "q0", "q1", "q2", "q3", "q4"},
                new String[] { "a", "b" },
                new String[] { "q2", "q4" },
                new Transition[] {
                        new Transition("q0", "a", "q1"),
                        new Transition("q0", "b", "q3"),
                        new Transition("q1", "a", "q2"),
                        new Transition("q1", "b", "q1"),
                        new Transition("q2", "a", "q2"),
                        new Transition("q2", "b", "q1"),
                        new Transition("q3", "a", "q3"),
                        new Transition("q3", "b", "q4"),
                        new Transition("q4", "a", "q3"),
                        new Transition("q4", "b", "q4"),
                },
                "q0"
        );

        String line;
        while (!(line = reader.readLine()).equals("end")) {
            problem4.input(line);
            if (problem4.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            problem4.reset();
        }

    }

    //////////// PROBLEM 5
    public static void problem5(BufferedReader reader, BufferedWriter writer) throws IOException {

        Dfa Problem5 = new Dfa(
                new String[] { "q0", "q1", "q2" },
                new String[] { "0", "1" },
                new String[] { "q0" },
                new Transition[] {
                        new Transition("q0", "0", "q0"),
                        new Transition("q0", "1", "q1"),
                        new Transition("q1", "1", "q1"),
                        new Transition("q1", "0", "q2"),
                        new Transition("q2", "1", "q1"),
                        new Transition("q2", "0", "q0"),

                },
                "q0");
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            Problem5.input(line);
            if (Problem5.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            Problem5.reset();
        }
    }

    // Problem5.input("0");
    // Problem5.input("10000");
    // Problem5.input("100");
    // Problem5.input("101");
    // System.out.println(Problem5.isAccepting());

    public static void problem6(BufferedReader reader, BufferedWriter writer) throws IOException {

        Dfa problem6 = new Dfa(
                new String[] { "q0", "q1", "q2", "q3", "q4"},
                new String[] { "0", "1" },
                new String[] { "q0", "q1", "q2" },
                new Transition[] {
                        new Transition("q0", "0", "q1"),
                        new Transition("q0", "1", "q2"),
                        new Transition("q1", "0", "q1"), //
                        new Transition("q1", "1", "q1"),
                        new Transition("q2", "0", "q1"),
                        new Transition("q2", "1", "q3"),
                        new Transition("q3", "0", "q1"),
                        new Transition("q3", "1", "q4"),
                        new Transition("q4", "0", "q1"),
                        new Transition("q4", "1", "q1"),
                },
                "q0"
        );

        String line;
        while (!(line = reader.readLine()).equals("end")) {
            problem6.input(line);
            if (problem6.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            problem6.reset();
        }

    }

    public static void problem7(BufferedReader reader, BufferedWriter writer) throws IOException {
        Nfa turnstileNfa = new Nfa(
                new String[] { "A", "B", "C", "D", "E", "F", "G" },
                new String[] { "0", "1" },
                new String[] { "A", "D", "G" },
                new Transition[] {
                        new Transition("A", "0", "B"),
                        new Transition("B", "0", "B"),
                        new Transition("B", "1", "C"),
                        new Transition("C", "1", "C"),
                        new Transition("C", "0", "D"),
                        new Transition("D", "0", "D"),
                        new Transition("D", "1", "C"),

                        new Transition("A", "1", "E"),
                        new Transition("E", "1", "E"),
                        new Transition("E", "0", "F"),
                        new Transition("F", "0", "F"),
                        new Transition("F", "1", "G"),
                        new Transition("G", "1", "G"),
                        new Transition("G", "0", "F"),
                },
                "A");
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            turnstileNfa.input(line);
            if (turnstileNfa.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            turnstileNfa.reset();
        }
    }

    public static void problem8(BufferedReader reader, BufferedWriter writer) throws IOException {
        Nfa turnstileNfa = new Nfa(
                new String[] { "q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8" },
                new String[] { "1", "0" },
                new String[] { "q4", "q8" },
                new Transition[] {
                        new Transition("q0", "", "q1"),
                        new Transition("q1", "0", "q1"),
                        new Transition("q1", "1", "q1"),
                        new Transition("q1", "1", "q2"),
                        new Transition("q2", "0", "q3"),
                        new Transition("q3", "1", "q4"),
                        new Transition("q4", "1", "q4"),
                        new Transition("q4", "0", "q4"),
                        new Transition("q0", "", "q5"),
                        new Transition("q5", "1", "q5"),
                        new Transition("q5", "0", "q5"),
                        new Transition("q5", "0", "q6"),
                        new Transition("q6", "1", "q7"),
                        new Transition("q7", "0", "q8"),
                        new Transition("q8", "1", "q8"),
                        new Transition("q8", "0", "q8"),
                },
                "q0");
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            // System.out.println(line);
            turnstileNfa.input(line);
            if (turnstileNfa.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            turnstileNfa.reset();
        }
    }

    public static void problem9(BufferedReader reader, BufferedWriter writer) throws IOException {
        Nfa turnstileNfa = new Nfa(
                new String[] { "q0", "q1", "q2", "q3", "q4", "q5", "q6" },
                new String[] { "1", "0" },
                new String[] { "q2", "q3", "q5", "q6" },
                new Transition[] {
                        new Transition("q0", "", "q1"),
                        new Transition("q1", "0", "q2"),
                        new Transition("q2", "1", "q3"),
                        new Transition("q3", "", "q1"),
                        new Transition("q0", "", "q4"),
                        new Transition("q4", "1", "q5"),
                        new Transition("q5", "0", "q6"),
                        new Transition("q6", "", "q4"),

                },
                "q0");
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            turnstileNfa.input(line);
            if (turnstileNfa.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            turnstileNfa.reset();
        }
    }

    public static void problem10(BufferedReader reader, BufferedWriter writer) throws IOException {
        Nfa turnstileNfa = new Nfa(
                new String[] { "q0", "q1", "q2" },
                new String[] { "1", "0" },
                new String[] { "q0", "q2" },
                new Transition[] {
                        new Transition("q0", "0", "q1"),
                        new Transition("q0", "1", "q0"),
                        new Transition("q1", "1", "q2"),
                        new Transition("q2", "", "q0"),
                },
                "q0");
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            System.out.println(line);
            turnstileNfa.input(line);
            if (turnstileNfa.isAccepting()) {
                writer.write("True\n");
            } else {
                writer.write("False\n");
            }
            turnstileNfa.reset();
        }

    }
}
