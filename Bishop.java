import java.awt.Color;
import java.awt.Graphics;

public class Bishop extends Piece {

	public Bishop(boolean isBlack) {
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
		g.fillOval(positionX+(int)(squareWidth*5.0/12.0), 
				positionY+squareWidth/6, 
				squareWidth/4, squareWidth/4);
		//draw the neck
		g.fillOval(positionX+(int)(squareWidth*3.0/9.0), 
				positionY+squareWidth/3, 
				squareWidth/3, squareWidth/3);
		//draw the base
		g.fillRect(positionX+(int)(squareWidth*1.0/4.0), 
				positionY+(int)(squareWidth*3.0/5.0), 
				squareWidth/2, squareWidth/5);

	}

	@Override
	public boolean canMove(int x, int y,int selectedSquareX,int selectedSquareY,Piece[][] pieces) {
		// TODO Auto-generated method stub
		if(x==y||x==-y){
			int i;
			int j;
			int cnt=0;
			if(x<0&&y<0){
				i=1;
				j=1;
			}else if(x<0&&y>0){
				i=1;
				j=-1;
			}else if(x>0&&y<0){
				i=-1;
				j=1;
			}else{
				i=-1;
				j=-1;
			}
			int mult=1;
			for(int k=0;k<x||k<-x;k++){
				if(pieces[selectedSquareX-i][selectedSquareY-j]==null){
					mult++;
					cnt++;
					if(x<0&&y<0){
						i=1;
						j=1;
					}else if(x<0&&y>0){
						i=1;
						j=-1;
					}else if(x>0&&y<0){
						i=-1;
						j=1;
					}else{
						i=-1;
						j=-1;
					}
					i=i*mult;
					j=j*mult;

				}
			}
			//if(isBlack){
			if((cnt==x||cnt==-x)&&x!=0){
				return true;
			}
			return false;
			//}
			//else{
			//if((cnt==x||cnt==-x)){
			//return true;
			//}
			//return false;

			//}
			//return (x==y||x==-y);
		}
		return false;
	}

	@Override
	public boolean canCapture(int x, int y,int selectedSquareX,int selectedSquareY,int targetSquareX,int targetSquareY, Piece[][] pieces) {
		// TODO Auto-generated method stub
		int i;
		int j;
		if((x==1||x==-1)&&(y==1||y==-1)){
			return true;
		}
		else if(x<0&&y<0){
			i=1;
			j=1;
		}else if(x<0&&y>0){
			i=1;
			j=-1;
		}else if(x>0&&y<0){
			i=-1;
			j=1;
		}else{
			i=-1;
			j=-1;
		}

		return canMove(x+i,y+j,targetSquareX-x,targetSquareY-y,pieces);
	}

}












