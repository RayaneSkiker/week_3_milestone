import java.util.Scanner;

public class TicTacToe 
{
	char [][] grid;
	Scanner scan=new Scanner(System.in);
	int a=(int)(Math.random()*2)+1;
	char a2;
	boolean a3=false;
	
	public TicTacToe()
	{
		grid=new char[3][3];
		for(int row=0; row<grid.length; row++)
		{
			for(int col=0; col<grid[row].length; col++)
			{
				grid[row][col]='*';
			}
		}
		
		if(a==1)
		{
			a2='X';
		}
		else
		{
			a2='O';
		}
	}
	
	public void Display()
	{
		for(int row2=0; row2<grid.length; row2++)
		{
			for(int col2=0; col2<grid[row2].length; col2++)
			{
				System.out.print(grid[row2][col2]+" ");
			}
			System.out.println();
		}
	}
	
	public void Turn()
	{
		for(int i=0; i<9 && a3==false; i++)
		{

				System.out.println("Current player is: "+a2);
				
				System.out.println("Enter the row number (1-3): ");
				int r=scan.nextInt();
		
				System.out.println("Enter the column number (1-3): ");
				int c=scan.nextInt();

				r-=1;
				c-=1;

				
				if(grid[r][c]=='X'||grid[r][c]=='O')
				{
					System.out.println("Position is already taken, please try again.");
					Turn();
					return;
				}
				
				grid[r][c]=a2;
				
				if(a2=='X')
				{
					a2='O';
				}
		
				else if(a2=='O')
				{
					a2='X';
				}
				Display();
				Winner();
		}
	}
	
	public void Winner()
	{
		if(grid[0][0]=='O' && grid[0][1]=='O' && grid[0][2]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[1][0]=='O' && grid[1][1]=='O' && grid[1][2]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[2][0]=='O' && grid[2][1]=='O' && grid[2][2]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[0][0]=='O' && grid[1][0]=='O' && grid[2][0]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[0][1]=='O' && grid[1][1]=='O' && grid[2][1]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[0][2]=='O' && grid[1][2]=='O' && grid[2][2]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[0][0]=='O' && grid[1][1]=='O' && grid[2][2]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[0][2]=='O' && grid[1][1]=='O' && grid[2][0]=='O')
		{
			System.out.println("O is the winner");
			a3=true;
		}
		
		else if(grid[0][0]=='X' && grid[0][1]=='X' && grid[0][2]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
		
		else if(grid[1][0]=='X' && grid[1][1]=='X' && grid[1][2]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
		
		else if(grid[2][0]=='X' && grid[2][1]=='X' && grid[2][2]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
		
		else if(grid[0][0]=='X' && grid[1][0]=='X' && grid[2][0]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
		
		else if(grid[0][1]=='X' && grid[1][1]=='X' && grid[2][1]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
		
		else if(grid[0][2]=='X' && grid[1][2]=='X' && grid[2][2]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
		
		else if(grid[0][0]=='X' && grid[1][1]=='X' && grid[2][2]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
		
		else if(grid[0][2]=='X' && grid[1][1]=='X' && grid[2][0]=='X')
		{
			System.out.println("X is the winner");
			a3=true;
		}
	}
	
	public static void main(String[] args) 
	{
		TicTacToe t=new TicTacToe();
		t.Display();
		t.Turn();
	}
}