import java.awt.Color;
import java.awt.Graphics;

public class King extends Piece{

	public King(boolean isBlack) {
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
		g.fillRect(positionX+(int)(squareWidth*2.0/6.0), 
				positionY+squareWidth/4, 
				squareWidth/3, squareWidth/6);
		//draw the neck
		g.fillRect(positionX+(int)(squareWidth*4.0/10.0), 
				positionY+squareWidth/12, 
				squareWidth/5, (int)(squareWidth*3.0/4.0));
		//draw the base
		g.fillRect(positionX+(int)(squareWidth*1.0/4.0), 
				positionY+(int)(squareWidth*3.0/5.0), 
				squareWidth/2, squareWidth/5);

	}

	@Override
	public boolean canMove(int x, int y,int selectedSquareX,int selectedSquareY,Piece[][] pieces) {
		// TODO Auto-generated method stub
		/*int i;
		int j;
		int cnt=0;
		if(x==1&&y==1){
			i=1;
			j=1;
		}else if(x==1&&y==0){
			i=1;
			j=-1;
		}else if(x==1&&y==-1){
			i=-1;
			j=1;
		}else if(x==0&&y==1){
			i=-1;
			j=-1;
		}else if(x==-1&&y==1){
			i=0;
			j=-1;
		}else if(x==0&&y==-1){
			i=0;
			j=1;
		}else if(x==0&&y==0){
			i=-1;
			j=0;
		}else if(x==-1&&y==-1){
			i=1;
			j=0;
		}else if(x==-1&&y==0){

		}
		for(int l=0;l<8;l++){
			for(int k=0;k<8;k++){
				if(pieces[k][l]!=null){
					if(pieces[k][l].canCapture(selectedSquareX+x-k, selectedSquareY+y-l,0,0, selectedSquareX+x, selectedSquareY+y, pieces)){
						System.out.print("zxcvbnmöç");
						return false;
					}
				}
			}
		}
*/
		return (x==1||y==1||x==-1||y==-1);
	}

	@Override
	public boolean canCapture(int x, int y,int selectedSquareX,int selectedSquareY,int targetSquareX,int targetSquareY, Piece[][] pieces) {
		// TODO Auto-generated method stub
		return (x==1||y==1||x==-1||y==-1);
	}

}
