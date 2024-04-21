import java.util.List;
import java.util.stream.Stream;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Represents a deterministic finite automaton (DFA), with a set of states and
 * transitions between those states.
 */
public class Dfa {
    private final String[] states;
    private final String[] inputAlphabet;
    private final String[] acceptingStates;

    /**
     * A HashMap of transitions. A HashMap is used to speed up searching
     * through the table to find the correct transition.
     * Keys are of the form input,currentState.
     */
    private final HashMap<String, Transition> transitions = new HashMap<>();

    private String startState;
    private String currentState;

    /**
     * Constructs a new DFA.
     * 
     * @param states          The set of states which the DFA may be in.
     * @param inputAlphabet   The set of inputs which may be supplied to the DFA.
     * @param acceptingStates The subset of states which are accepting.
     * @param transitions     A list of transitions between states on inputs.
     * @param startState      The starting state.
     */
    public Dfa(String[] states, String[] inputAlphabet,
            String[] acceptingStates, Transition[] transitions, String startState) {
        // Due to transition keys' comma-separated nature, state or input names
        // may not contain commas

        if (Stream.of(states).anyMatch(x -> x.contains(","))) {
            throw new InvalidParameterException("State names may not contain commas");
        }

        if (Stream.of(inputAlphabet).anyMatch(x -> x.contains(","))) {
            throw new InvalidParameterException("Inputs may not contain commas");
        }

        this.states = states;
        this.inputAlphabet = inputAlphabet;
        this.acceptingStates = acceptingStates;

        this.startState = startState;
        this.currentState = startState;

        for (Transition t : transitions) {
            List<String> statesAsList = Arrays.asList(this.states);
            if (!statesAsList.contains(t.newState)
                    || !statesAsList.contains(t.startState)) {
                throw new InvalidParameterException("Transition refers to state which does not exist");
            }

            if (!Arrays.asList(inputAlphabet).contains(t.input)) {
                throw new InvalidParameterException("Transition refers to input which does not exist");
            }

            String key = getKeyForTransition(t.input, t.startState);

            this.transitions.put(key, t);
        }
    }

    /**
     * Resets the DFA to its starting state.
     * This method returns the object it is called on, so may be chained.
     */
    public Dfa reset() {
        currentState = startState;
        return this;
    }

    /**
     * Given a valid input, transitions the DFA to another state according to
     * the transition table.
     * This method returns the object it is called on, so may be chained.
     * 
     * @param input The input to the DFA.
     */
    public Dfa input(String input) {
        // Check that this input is contained within the input alphabet
        for (int i = 0; i < input.length(); i++) {
            String str = String.valueOf(input.charAt(i));
            if (!Arrays.asList(inputAlphabet).contains(str)) {
                throw new InvalidParameterException("'" + str + "' is not a valid input");
            }

            String key = getKeyForTransition(str, currentState);

            Transition transition = transitions.get(key);
            if (transition == null) {
                throw new InvalidParameterException("No transition found for: " + str);
            }

            currentState = transition.newState;
        }

        return this;
    }

    /**
     * Returns the current state of the DFA.
     */
    public String getState() {
        return currentState;
    }

    /**
     * Returns true if the current state is contained within the set of
     * accepting states.
     */
    public boolean isAccepting() {
        return Arrays.asList(acceptingStates).contains(currentState);
    }

    /**
     * Calculates the HashMap key used to look up the transition which should
     * be taken, given the current state and an input.
     */
    private String getKeyForTransition(String input, String state) {
        return input + "," + state;
    }
}