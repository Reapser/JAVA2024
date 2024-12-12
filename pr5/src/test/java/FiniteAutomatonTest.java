import org.example.FiniteAutomaton;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiniteAutomatonTest {

    @Test
    public void testCompleteMatch() {
        FiniteAutomaton automaton = new FiniteAutomaton();
        automaton.reset();
        assertEquals("F", automaton.processInput("abcTESTabc"));
    }

    @Test
    public void testPartialMatch() {
        FiniteAutomaton automaton = new FiniteAutomaton();
        automaton.reset();
        assertEquals("3", automaton.processInput("abcTES"));
    }

    @Test
    public void testNoMatch() {
        FiniteAutomaton automaton = new FiniteAutomaton();
        automaton.reset();
        assertEquals("S", automaton.processInput("abcabc"));
    }

    @Test
    public void testMultipleMatches() {
        FiniteAutomaton automaton = new FiniteAutomaton();
        automaton.reset();
        assertEquals("F", automaton.processInput("TESTTEST"));
    }
}
