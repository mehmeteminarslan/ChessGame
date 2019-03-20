import java.awt.Color;
import java.awt.Graphics;

public class Rook extends Piece{

	public Rook(boolean isBlack) {
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
		g.fillRect(positionX+(int)(squareWidth*2.0/8.0), 
				positionY+squareWidth/7, 
				squareWidth/2, squareWidth/5);
		//draw the neck
		g.fillRect(positionX+(int)(squareWidth*2.0/6.0), 
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
		int i;
		int j;
		int cnt=0;

		if(x==0&&y>0){
			i=0;
			j=-1;
		}else if(x==0&&y<0){
			i=0;
			j=1;
		}else if(y==0&&x>0){
			i=-1;
			j=0;
		}else{
			i=1;
			j=0;
		}
		int mult=1;
		for(int k=0;k<x||k<-x||k<y||k<-y;k++){
			if(pieces[selectedSquareX-i][selectedSquareY-j]==null){
				mult++;
				cnt++;
				if(x==0&&y>0){
					i=0;
					j=-1;
				}else if(x==0&&y<0){
					i=0;
					j=1;
				}else if(y==0&&x>0){
					i=-1;
					j=0;
				}else if(x<0&&y==0){
					i=1;
					j=0;
				}else{
					i=0;
					j=0;
				}
				i=i*mult;
				j=j*mult;
			}
		}
		if(x==0&&y!=0){
			if(cnt==y||cnt==-y){
				return true;
			}
		}else if(y==0&&x!=0){
			if(cnt==x||cnt==-x){
				return true;
			}
		}else if(x==0&&y==0){
			return true;
		}
		return false;
	}

	@Override
	public boolean canCapture(int x, int y,int selectedSquareX,int selectedSquareY,int targetSquareX,int targetSquareY, Piece[][] pieces) {
		// TODO Auto-generated method stub
		int i;
		int j;

		if(x==0&&y>0){
			i=0;
			j=-1;
		}else if(x==0&&y<0){
			i=0;
			j=1;
		}else if(y==0&&x>0){
			i=-1;
			j=0;
		}else{
			i=1;
			j=0;
		}

		return canMove(x+i,y+j,targetSquareX-x,targetSquareY-y,pieces);
	}

}
