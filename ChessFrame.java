import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ChessFrame extends JFrame implements MouseListener{

	/**
	 * width of one square on the board.
	 * Change this to have a bigger or smaller 
	 * game frame. 
	 */
	public static final int SQUARE_WIDTH = 45;

	/**
	 * margins of the board on the frame
	 */
	public static final int BOARD_MARGIN = 50;

	int selectedSquareX = -1;
	int selectedSquareY = -1;
	Piece pieces[][] = new Piece[8][8];
	int counter=0;

	public ChessFrame(){

		initializeChessBoard();
		setTitle("Chess Game");
		//let the screen size fit the board size
		setSize(SQUARE_WIDTH*8+BOARD_MARGIN*2, SQUARE_WIDTH*8+BOARD_MARGIN*2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);

	}

	public void initializeChessBoard(){
		for(int i = 0; i<8; i++){
			for(int j = 0; j<8; j++){

				if(j==0){
					if(i==0||i==7){
						pieces[i][j]=new Rook(true);
					}
					else if(i==1||i==6){
						pieces[i][j]=new Knight(true);
					}
					else if(i==2||i==5){
						pieces[i][j]=new Bishop(true);
					}
					else if(i==3){
						pieces[i][j]=new Queen(true);
					}
					else{
						pieces[i][j]=new King(true);
					}
				}

				else if(j == 1){
					//add a black pawn here
					pieces[i][j] = new Pawn(true);
				}
				else if(j == 6){
					//add a white pawn here
					pieces[i][j] = new Pawn(false);
				}
				else if(j==7){
					if(i==0||i==7){
						pieces[i][j]=new Rook(false);
					}
					else if(i==1||i==6){
						pieces[i][j]=new Knight(false);
					}
					else if(i==2||i==5){
						pieces[i][j]=new Bishop(false);
					}
					else if(i==3){
						pieces[i][j]=new Queen(false);
					}
					else{
						pieces[i][j]=new King(false);
					}
				}
				else {

					pieces[i][j] = null;
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//print the board 's lines to show squares
		for(int i = 0; i<=8; i++)
		{
			g.drawLine(BOARD_MARGIN, 
					BOARD_MARGIN+(i)*SQUARE_WIDTH, 
					BOARD_MARGIN+8*SQUARE_WIDTH, 
					BOARD_MARGIN+(i)*SQUARE_WIDTH);
			g.drawLine(BOARD_MARGIN+(i)*SQUARE_WIDTH, 
					BOARD_MARGIN, 
					BOARD_MARGIN+(i)*SQUARE_WIDTH, 
					BOARD_MARGIN+8*SQUARE_WIDTH);
		}
		//print the pieces
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(pieces[i][j] != null)
				{
					pieces[i][j].drawYourself(g, i*SQUARE_WIDTH+BOARD_MARGIN, 
							j*SQUARE_WIDTH+BOARD_MARGIN, SQUARE_WIDTH);
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");

	}
	@Override
	public void mousePressed(MouseEvent e){
		// TODO Auto-generated method stub

		System.out.println("Pressed");
		//calculate which square is selected 
		selectedSquareX = (e.getX()-BOARD_MARGIN)/SQUARE_WIDTH;
		selectedSquareY = (e.getY()-BOARD_MARGIN)/SQUARE_WIDTH;
		if((pieces[selectedSquareX][selectedSquareY]!=null)){
			if((pieces[selectedSquareX][selectedSquareY].isBlack)&&(counter%2==0)){

				selectedSquareX=-1;
				selectedSquareY=-1;
				System.out.println(selectedSquareX+","+selectedSquareY);
			}
			if(!(pieces[selectedSquareX][selectedSquareY].isBlack)&&(counter%2==1)){

				selectedSquareX=-1;
				selectedSquareY=-1;
				System.out.println(selectedSquareX+","+selectedSquareY);
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Released");
		//calculate which square is targeted
		int targetSquareX = (e.getX()-BOARD_MARGIN)/SQUARE_WIDTH;
		int targetSquareY = (e.getY()-BOARD_MARGIN)/SQUARE_WIDTH;

		System.out.println(targetSquareX+","+targetSquareY+"\n");

		//if these are inside the board
		if(selectedSquareX >= 0 && selectedSquareY >= 0 &&
				selectedSquareX < 8 && selectedSquareY < 8 &&
				targetSquareX >= 0 && targetSquareY >= 0 &&
				targetSquareX < 8 && targetSquareY < 8){


			//if a piece is selected (before in mousePressed)
			if(pieces[selectedSquareX][selectedSquareY] != null){
				//get the distance of the drag-drop
				int diffX = targetSquareX - selectedSquareX;
				int diffY = targetSquareY - selectedSquareY;
				//if there is a piece in targeted square
				if(pieces[targetSquareX][targetSquareY] != null){
					if((pieces[selectedSquareX][selectedSquareY].isBlack!=pieces[targetSquareX][targetSquareY].isBlack)){
						if(pieces[selectedSquareX][selectedSquareY].canCapture(diffX, diffY,selectedSquareX,selectedSquareY,targetSquareX,targetSquareY,pieces)){

							pieces[targetSquareX][targetSquareY] = pieces[selectedSquareX][selectedSquareY];

							pieces[selectedSquareX][selectedSquareY] = null;
							counter++;
						}
					}
				}
				else{
					//if targeted square is empty
					if(pieces[selectedSquareX][selectedSquareY].canMove(diffX, diffY,selectedSquareX,selectedSquareY,pieces)){


						pieces[targetSquareX][targetSquareY] = pieces[selectedSquareX][selectedSquareY];

						pieces[selectedSquareX][selectedSquareY] = null;
						counter++;
					}
				}
			}
		}


		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Entered");

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Exited");

	}
}
