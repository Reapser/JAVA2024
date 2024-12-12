package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FiniteAutomaton automaton = new FiniteAutomaton();

        automaton.reset();
        System.out.println("Результат для 'abcTESTabc':" + automaton.processInput("abcTESTabc"));

        automaton.reset();
        System.out.println("Результат для 'abcTEST':'" + automaton.processInput("abcTEST"));

        }
    }
