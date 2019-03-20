import java.awt.Color;
import java.awt.Graphics;

public class Knight extends Piece{

	public Knight(boolean isBlack) {
		super(isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawYourself(Graphics g, int positionX, int positionY, int squareWidth) {
		// TODO Auto-generated method stub
		if(isBlack)
		{
			g.setColor(Color.black);
		}
		else
		{
			g.setColor(Color.GRAY);
		}

		//draw the head
		g.fillRect(positionX+(int)(squareWidth*1.0/4.0), 
				positionY+(int)(squareWidth*1.0/5.0), 
				squareWidth/2, squareWidth/5);
		g.fillOval(positionX+(int)(squareWidth*1.0/6.0), 
				positionY+squareWidth/4, 
				squareWidth/4, squareWidth/4);
		g.fillOval(positionX+(int)(squareWidth*2.0/6.0), 
				positionY+squareWidth/8, 
				squareWidth/3, squareWidth/3);
		g.fillOval(positionX+(int)(squareWidth*3.0/6.0), 
				positionY+squareWidth/8, 
				squareWidth/4, squareWidth/3);
		//draw the neck
		g.fillRect(positionX+(int)(squareWidth*5.0/10.0), 
				positionY+squareWidth/4, 
				squareWidth/4, squareWidth/2);
		//draw the base
		g.fillRect(positionX+(int)(squareWidth*1.0/4.0), 
				positionY+(int)(squareWidth*3.0/5.0), 
				squareWidth/2, squareWidth/5);

	}

	@Override
	public boolean canMove(int x, int y,int selectedSquareX,int selectedSquareY,Piece[][] pieces) {
		// TODO Auto-generated method stub
		if((x==2||x==-2)&&(y==1||y==-1)||(x==1||x==-1)&&(y==2||y==-2)){
			return true;
		}
		return false;
	}

	public boolean canCapture(int x, int y,int selectedSquareX,int selectedSquareY,int targetSquareX,int targetSquareY, Piece[][] pieces) {
		// TODO Auto-generated method stub

		return canMove(x,y,targetSquareX,targetSquareY,pieces);
	}

}
