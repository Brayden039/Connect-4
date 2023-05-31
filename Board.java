import java.util.*;
public class Board
{
  private int row;
  private int col;
  private int turn;
  private String[][] grid;
  Scanner keyboard = new Scanner(System.in);

  public Board()
  {
    row = 6;
    col = 7;
    grid = new String[row][col];

    for(int i = 0; i < row; i++)
    {
      for(int j = 0; j < col; j++)
      {
        grid[i][j] = "null";
      }
    }
  }

  public void printGrid()
  {
    for(int i = 0; i < row; i++)
    {
      for(int j = 0; j < col; j++)
      {
        if(grid[i][j].equals("YELLOW"))
        {
          System.out.print("YELLOW" + " ");
        }
        if(grid[i][j].equals("RED"))
        {
          System.out.print("RED" + " ");
        }
        //these lines can probably be removed later
        if(grid[i][j] != "RED" || grid[i][j] != "YELLOW")
        {
          System.out.print("null" + " ");
        }
      }
      System.out.println(" ");
    }
  }

  boolean win = false;
  public boolean checkWin()
  {
    //vert
    for(int i = 0; i < row; i++)
    {
      for(int j = 0; j < col; j++)
      {
        if(grid[i][j].equals("RED") && grid[i][j+1].equals("RED") && grid[i][j+2].equals("RED") && grid[i][j+3].equals("RED"))
        {
          System.out.println("Red wins!");
          win = true;
        }
        if(grid[i][j].equals("YELLOW") && grid[i][j+1].equals("YELLOW") && grid[i][j+2].equals("YELLOW") && grid[i][j+3].equals("YELLOW"))
        {
          System.out.println("Yellow wins!");
          win = true;
        }
        

      }
    }
    //hori
    for(int i2 = 0; i2 < row; i2++)
    {
      for(int j2 = 0; j2 < col; j2++)
      {
        if(grid[i2][j2].equals("RED") && grid[i2][j2+1].equals("RED") && grid[i2][j2+2].equals("RED") && grid[i2][j2+3].equals("RED"))
        {
          System.out.println("Red wins!");
          win = true;
        }
        if(grid[i2][j2].equals("YELLOW") && grid[i2+1][j2].equals("YELLOW") && grid[i2+2][j2].equals("YELLOW") && grid[i2+3][j2].equals("YELLOW"))
        {
          System.out.println("Yellow wins!");
          win = true;
        }
        

      }
    }

    //diag

    //end
    return win;
  }

  public void play()
  {
    turn = 0;
    System.out.println("What col would you like to place your piece? ");
    int colPlacePiece = keyboard.nextInt();
    //the piece needs to fall to the bottom however this code for now
    for(int i = 0; i < row; i++)
    {
      if((grid[row][colPlacePiece] != "RED") && (grid[row][colPlacePiece] != "YELLOW"))
      {
        if(turn%2 == 0)
        {
          grid[row][col] = "YELLOW";
          turn++;
        }
        else
        {
          grid[row][col] = "RED";
          turn++;
        }
      }
    }
    
  }





  
}