package ui;
import model.PlayController;
import java.util.Scanner;
public class Main {
    //Attribute
    private int height;
    private int width;
    //Relationship
    private PlayController pc;
    private Scanner sc;
    //Builder
    public Main() {
        sc = new Scanner(System.in);
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.operation();
    }
    private void operation() {
        System.out.println("ingrese el alto del tablero");
        height= sc.nextInt();
        System.out.println("ingrese el ancho del tablero ");
        width = sc.nextInt();
        pc = new PlayController(height*width);
        pc.addPlayer("J1",1);
        pc.addPlayer("J2",1);
        play(1,2);
    }
    private void play(int turn,int nextturn) {
        int dice=0,fate=0;
        System.out.println("turno del juagdor "+ turn);
        System.out.println(
                        "1. tirar dado \n" +
                        "2. ver el tablero \n"+
                                "3. salir");
         fate = sc.nextInt();
        switch (fate){
            case 1:
                dice=(int)(Math.random()*6+1);
                System.out.println("Dado: "+dice);
                if(!checkwin(pc.getPlayerPosition(turn),dice)){
					pc.setPositionOnBoard(turn,(pc.getPlayerPosition(turn)+dice));
                }else {
                    System.out.println("el jugador "+turn+ " gano la partida");
					return;
                }
            break;
			case 2:
				pc.print(height,width,0);
			break;
            case 3: 
				System.out.println("el jugador "+nextturn+" gano la partida"); 
				return;
			break;
        }
		play(nextturn,turn);
    }
    private boolean checkwin(int playerPosition, int dice) {
		if((playerPosition+dice)>=(height*width)){
			return true;
		}else{
			return false;
		}
    }
}