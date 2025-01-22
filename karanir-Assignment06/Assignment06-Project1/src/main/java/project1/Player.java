package project1;

/**
 * Player class
*/

public abstract class Player {
    private String name;  // stores player name and X/O marker
    private char marker; 

    public Player(String name, char marker) {
        this.name = name;  // initialize
        this.marker = marker; 
    }

    //getters for name and marker
    public String getName() {
        return name;  
    }

    public char getMarker() {
        return marker;  
    }

    public abstract int[] getMove(Board board);  // abstract method for player move
}
