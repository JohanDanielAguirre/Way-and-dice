package model;

public class PlayController {
    //Relationship
    private Board bd;
    private Player[] players;
    //Builder
    public PlayController(int valueBoard) {
        bd = new Board();
        createBoard(valueBoard,0);
        players = new Player[2];
        setPositionOnBoard();
    }
    private void createBoard(int value,int pointer) {
        if (pointer == value) return;
        bd.addBox(new Box(++pointer));
        createBoard(value,++pointer);
    }
    public void addPlayer(String name, int position) {
        if (players[0] == null) players[0] = new Player(name, position);
        else if (players[1] == null) players[1] = new Player(name, position);
        else System.out.println("No space");
        setPositionOnBoard();
    }
    public int getPlayerPosition(int player) {
        return players[player].getPosition();
    }
    public void setPositionOnBoard(int player, int nextBox) {
        bd.setBoxState(players[player].getPosition(),0);
        players[player].setPosition(nextBox);
        bd.setBoxState(nextBox,1);
        setPositionOnBoard();
    }
    private void setPositionOnBoard() {
        bd.setBoxState(players[0].getPosition(),1);
        bd.setBoxState(players[1].getPosition(),1);
    }
    public void print(int height, int width, int value) {
        if (value == height*width) return;
        String out = "";
        if (bd.valueBox(value) == State.OCCUPIED) {
            if (players[0].getPosition() == value)
                out += players[0].getName() + " ";
            if (players[1].getPosition() == value)
                out += players[1].getName();
        } else out = ""+value;
        if (value%width == 0) System.out.println();
        System.out.print("[ " + out + " ] ");
        print(height, width, ++value);
    }
}
