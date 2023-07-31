import java.awt.Component;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Minesweeper extends JFrame implements MouseListener
{
	private int max;
	private int [][] ints;
	private JButton [][] grid;
	
	public Minesweeper(int max)
	{
		this.max=max;
		ints=new int[10][10];
		setRandom();
		
		grid=new JButton[10][10];
		setSize(150,150);
		Guibuilder();
	}


	public void Guibuilder()
	{
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(10, 10));

		for(int r=0; r<grid.length; r++)
			for(int c=0; c<grid[r].length; c++)
			{
				grid[r][c]=new JButton("*");
				grid[r][c].setActionCommand(r+":"+c);
				grid[r][c].addMouseListener(this);
				getContentPane().add(grid[r][c]);
			}

		setVisible(true);
	}
	public void mouseClicked(MouseEvent e)
	{

	}
	public void mouseEntered(MouseEvent e)
	{
	    
	}
	public void mouseExited(MouseEvent e)
	{
	    
	}
	public void mouseReleased(MouseEvent e)
	{
	    
	}
	public void mousePressed(MouseEvent e)
	{
		Component a=e.getComponent();		
		JButton b=(JButton)a;
		String c=b.getActionCommand();
		int d=c.indexOf(":");
		String f="F";
		String f2="*";

		if(SwingUtilities.isRightMouseButton(e))
		{
			String s=b.getText();
			
			if(s=="*")
				b.setText(f);
			else if(s=="F")
				b.setText(f2);
		}

		if(SwingUtilities.isLeftMouseButton(e))
		{
			if (d>=0)
			{
				String r=c.substring(0,d);
				String co=c.substring(d+1);
				int r2=Integer.parseInt(r);
				int co2=Integer.parseInt(co);
				String g=""+ints[r2][co2];

				if(ints[r2][co2]==-1)
				{
					JOptionPane.showMessageDialog(null, "BOOM");
					for(int row=0; row<ints.length; row++)
						for(int col=0; col<ints[row].length; col++)
						{
							String g2=""+ints[row][col];
							grid[row][col].setText(g2);
						}
				}
				else if(ints[r2][co2]!=-1)
				{
					b.setText(g);
				}
			}
		}		
	}

	public void setRandom()
	{
		int i=1;
		while(i<=max)
		{
		int a=(int)(Math.random()*10);
		int b=(int)(Math.random()*10);

			if (ints[a][b]!=-1)
			{
				ints[a][b]=-1;
				i++;
			}
		}
	}
	public int count(int r,int c)
	{
	int i=0;


        if(r-1<0||c-1<0||r-1>=ints.length||c-1>=ints.length)
        {

            i=i;
        }
		else if(ints[r-1][c-1]==-1)
		{
			i+=1;
		}
		if(r-1<0||c<0||r-1>=ints.length||c>=ints.length)
		{
		    i=i;
		}
		else if(ints[r-1][c]==-1)
		{
			i+=1;
		}
		if(r<0||c-1<0||r>=ints.length||c-1>=ints.length)
		{
		    i=i;
		}
		else if(ints[r][c-1]==-1)
		{
			i+=1;
		}
		if(r+1<0||c+1<0||r+1>=ints.length||c+1>=ints.length)
		{
		    i=i;
		}
		else if(ints[r+1][c+1]==-1)
		{
			i+=1;
		}
		if(r+1<0||c<0||r+1>=ints.length||c>=ints.length)
		{
		    i=i;
		}
		else if(ints[r+1][c]==-1)
		{
			i+=1;
		}
		if(r<0||c+1<0||r>=ints.length||c+1>=ints.length)
		{
		    i=i;
		}
		else if(ints[r][c+1]==-1)

		{
			i+=1;
		}
		if(r+1<0||c-1<0||r+1>=ints.length||c-1>=ints.length)
		{
		    i=i;
		}
		else if(ints[r+1][c-1]==-1)
		{
			i+=1;
		}
		if(r-1<0||c+1<0||r-1>=ints.length||c+1>=ints.length)
		{
		    i=i;
		}
		else if(ints[r-1][c+1]==-1)
		{
			i+=1;
		}
		return i;
	}
	
	public void setCounts()
	{
		for(int a=0; a<ints.length; a++)
			for(int b=0; b<ints.length; b++)
				if(ints[a][b]!=-1)
				{
				    int c=count(a,b);
				    ints[a][b]+=c;
				}
	}


	public static void main(String[] args)
	{	
		Minesweeper a=new Minesweeper(20);
		a.setCounts();
	}
}
