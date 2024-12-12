package org.example;

public class FiniteAutomaton {
    private String state;

    public FiniteAutomaton() {
        this.state = "S";

    }
    public void reset() {
        this.state = "S";
    }

    public String processInput (String inputString){
        for (char c : inputString.toCharArray()) {
            switch (state) {
                case "S":
                    if (c == 'T') {
                        state = "1";
                    }
                    break;
                case "1":
                    if (c == 'E') {
                        state = "2";
                    } else if (c != 'T') {
                        state = "S";
                    }
                    break;
                case "2":
                    if (c == 'S') {
                        state = "3";
                    } else if (c != 'E') {
                        state = "S";
                    }
                    break;
                case "3":
                    if (c == 'T') {
                        state = "F";
                    } else if (c != 'S') {
                        state = "S";
                    }
                    break;
                case "F":
                    break;
            }
        }
        return state;
    }

}





