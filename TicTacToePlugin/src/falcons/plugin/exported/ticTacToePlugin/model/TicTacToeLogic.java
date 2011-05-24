package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import falcons.plugin.Pluggable;

public class TicTacToeLogic implements Pluggable, Serializable{
	
	private TicTacToeModel model;
	private boolean win = false;
	private int fullBoard = 0;
	private String winner = null;
	private JButton[] board;
	private boolean me = false;
	
	public TicTacToeLogic(){
		
	}
	
	public TicTacToeLogic(TicTacToeModel model){
		this.model = model;
		board = model.getBoard();
	}
	
	//If b == true, you've played. If b == false your opponent have played. If me it's your turn
	public void turn(int i){
		if(model.getBoard()[i].getText() == "" && me){
			model.changeO(i);
			me = false;
			win();
		}
		else if(model.getBoard()[i].getText() == ""){
			model.changeX(i);
			me = true;
			win();
		}
	}
	
	public void setMe(boolean b){
		me = b;
	}
	
	public long getDestination(){
		return model.getDestination();
	}
	
	public void setDestination(long dest){
		model.setDestination(dest);
	}
	
	public void win(){
		
		int[][] winCombinations = new int[][] {
			    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
			    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
			    {0, 4, 8}, {2, 4, 6}             //diagonal wins
		};
		
		for(int i=0; i<=7; i++){
		    if( board[winCombinations[i][0]].getText().equals(board[winCombinations[i][1]].getText()) && 
		        board[winCombinations[i][1]].getText().equals(board[winCombinations[i][2]].getText()) && 
		        board[winCombinations[i][0]].getText() != ""){
		        win = true;
		        winner = board[winCombinations[i][0]].getText();
		    }
		}
		if(win){
			JOptionPane.showMessageDialog(null, winner + " har vunnit!");
		}
		restart();
	}
	
	public void restart(){
		for(int i=0; i<9; i++){
			if(board[i].getText() != ""){
				fullBoard++;
			}
		}
		if(win || fullBoard == 9){
			model.reset();
			win = false;
			fullBoard = 0;
		}
	}
}