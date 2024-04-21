public class App {
    public static void main(String[] args) throws Exception {
        // Nfa turnstileNfa = new Nfa(
        //         new String[] { "A", "B", "C", "D", "E", "F", "G"},
        //         new String[] { "0", "1" },
        //         new String[] { "A", "D", "G"},
        //         new Transition[] {
        //                 new Transition("A", "0", "B"),
        //                 new Transition("B", "0", "B"),
        //                 new Transition("B", "1", "C"),
        //                 new Transition("C", "1", "C"),
        //                 new Transition("C", "0", "D"),
        //                 new Transition("D", "0", "D"),
        //                 new Transition("D", "1", "C"),

        //                 new Transition("A", "1", "E"),
        //                 new Transition("E", "1", "E"),
        //                 new Transition("E", "0", "F"),
        //                 new Transition("F", "0", "F"),
        //                 new Transition("F", "1", "G"),
        //                 new Transition("G", "1", "G"),
        //                 new Transition("G", "0", "F"),
        //         },
        //         "A");

        Nfa turnstileNfa = new Nfa(
            new String[] { "q0", "q1","q2","q3","q4","q5","q6","q7","q8"},
            new String[] { "1", "0" },
            new String[] { "q4","q8" },
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
            "q0"
            );

        // Nfa turnstileNfa = new Nfa(
        //         new String[] { "q0", "q1", "q2", "q3"},
        //         new String[] {"a"},
        //         new String[] { "q2" },
        //         new Transition[] {
        //                 new Transition("q0", "a", "q1"),
        //                 new Transition("q0", "a", "q3"),
        //                 new Transition("q1", "a", "q2"),
                        
        //         },
        //         "q0");

        // turnstileNfa.input("0").input("1").
        // input("0").input("1").input("1").input("0");

        turnstileNfa.input("1").input("0").
        input("1").input("0").input("1").input("0");

        // turnstileDfa.input("010110");
        // turnstileDfa.input("101010");
        // turnstileNfa.input("a").input("a");
        // turnstileNfa.input("101010");


        System.out.println(turnstileNfa.isAccepting());
    }
}
