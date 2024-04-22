import java.security.InvalidParameterException;
import java.util.*;

public class Nfa {
    private final String[] states;
    private final String[] inputAlphabet;
    private final String[] acceptingStates;

    /**
     * A HashMap of transitions. A HashMap is used to speed up searching
     * through the table to find the correct transition.
     * Keys are of the form input,currentState.
     */
    private final Map<String, Set<Transition>> transitions = new HashMap<>();

    private String startState;
    private Set<String> currentState;

    /**
     * Constructs a new NFA.
     *
     * @param states          The set of states which the NFA may be in.
     * @param inputAlphabet   The set of inputs which may be supplied to the NFA.
     * @param acceptingStates The subset of states which are accepting.
     * @param transitions     A list of transitions between states on inputs.
     * @param startState      The starting state.
     */
    public Nfa(String[] states, String[] inputAlphabet,
                                           String[] acceptingStates, Transition[] transitions, String startState) {
        this.states = states;
        this.inputAlphabet = inputAlphabet;
        this.acceptingStates = acceptingStates;
        this.startState = startState;

        // Initialize current state to the start state
        currentState = new HashSet<>();
        currentState.add(startState);

        // Populate transitions
        for (Transition t : transitions) {
            String key = getKeyForTransition(t.input, t.startState);
            this.transitions.computeIfAbsent(key, k -> new HashSet<>()).add(t);
        }
    }

    /**
     * Resets the NFA to its starting state.
     * This method returns the object it is called on, so may be chained.
     */
    public Nfa reset() {
        currentState.clear();
        currentState.add(startState);
        return this;
    }

    /**
     * Given an input, transitions the NFA to another state according to
     * the transition table.
     * This method returns the object it is called on, so may be chained.
     *
     * @param input The input to the NFA.
     */
    public Nfa input(String input) throws InvalidParameterException {
        for (int i = 0; i < input.length(); i++) {
            String str = String.valueOf(input.charAt(i));
            // System.out.println("i = "+i+", str = "+str);
            // Check that this input is contained within the input alphabet
            if (!Arrays.asList(inputAlphabet).contains(str) && !str.equals("")) {
                throw new InvalidParameterException("'" + str + "' is not a valid input");
            }

            Set<String> nextState = new HashSet<>();

            // Explore all possible transitions from the current state
            boolean epsilonTrans = false;
            for (String state : currentState) {
                epsilonTrans = false;
                // For epsilon transition
                String epsilonKey = getKeyForTransition("", state);
                Set<Transition> epsilonTransitions = transitions.getOrDefault(epsilonKey, Collections.emptySet());
                // System.out.println("epsilon trans: "+ epsilonTransitions);
                for (Transition epsilonTransition : epsilonTransitions) {
                    nextState.add(epsilonTransition.newState);
                }

                // For non-epsilon transitions
                if (!str.equals("")) {
                    String key = getKeyForTransition(str, state);
                    Set<Transition> possibleTransitions = transitions.getOrDefault(key, Collections.emptySet());
                    for (Transition transition : possibleTransitions) {
                        nextState.add(transition.newState);
                    }
                    // System.out.println("non-epsilon trans: "+ possibleTransitions);
                    if (possibleTransitions.isEmpty()) {
                        epsilonTrans = true;
                    }
                }
            }
            if (epsilonTrans) {
                i--;
            }

            // Update current state
            currentState = nextState;
            // System.out.println(currentState);
        }
        return this;
    }

    /**
     * Returns the current state of the NFA.
     */
    public Set<String> getState() {
        return currentState;
    }

    /**
     * Returns true if any of the current states are accepting states.
     */
    public boolean isAccepting() {
        for (String state : currentState) {
            if (Arrays.asList(acceptingStates).contains(state)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the HashMap key used to look up the transition which should
     * be taken, given the current state and an input.
     */
    private String getKeyForTransition(String input, String state) {
        return input + "," + state;
    }
}
