import java.awt.Color;
import java.awt.Graphics;

public class Queen extends Piece {

	public Queen(boolean isBlack) {
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
		g.fillOval(positionX+(int)(squareWidth*3.0/7.0), 
				positionY+squareWidth/20, 
				squareWidth/5, squareWidth/5);
		g.fillRect(positionX+(int)(squareWidth*2.0/6.0), 
				positionY+squareWidth/4, 
				squareWidth/3, squareWidth/8);
		//draw the neck
		g.fillRect(positionX+(int)(squareWidth*4.0/10.0), 
				positionY+squareWidth/5, 
				squareWidth/5, (int)(squareWidth*2.0/3.0));
		//draw the base
		g.fillRect(positionX+(int)(squareWidth*1.0/4.0), 
				positionY+(int)(squareWidth*4.0/6.0), 
				squareWidth/2, squareWidth/5);
	}

	@Override
	public boolean canMove(int x, int y,int selectedSquareX,int selectedSquareY,Piece[][] pieces) {
		// TODO Auto-generated method stub
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
		}else if((x>0&&y>0)){
			i=-1;
			j=-1;
		}else if(x==0&&y>0){
			i=0;
			j=-1;
		}else if(x==0&&y<0){
			i=0;
			j=1;
		}else if(y==0&&x>0){
			i=-1;
			j=0;
		}else if(x>0&&y==0){
			i=1;
			j=0;
		}else{
			i=0;
			j=0;
		}

		int mult=1;
		for(int k=0;k<x||k<-x||k<y||k<-y;k++){
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
				}else if((x>0&&y>0)){
					i=-1;
					j=-1;
				}else if(x==0&&y>0){
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
		}else if(cnt==y||cnt==-y){
			return true;
		}
		return false;
	}



	@Override
	public boolean canCapture(int x, int y,int selectedSquareX,int selectedSquareY,int targetSquareX,int targetSquareY, Piece[][] pieces) {
		// TODO Auto-generated method stub
		int i;
		int j;
		if(x<0&&y<0){
			i=1;
			j=1;
		}else if(x<0&&y>0){
			i=1;
			j=-1;
		}else if(x>0&&y<0){
			i=-1;
			j=1;
		}else if((x>0&&y>0)){
			i=-1;
			j=-1;
		}else if(x==0&&y>0){
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
