import java.util.*;
public class Board
{
  private int row;
  private int col;
  private int turn;
  private String[][] grid;
  

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
          System.out.print("YELLOW ");
        }
        if(grid[i][j].equals("RED"))
        {
          System.out.print("RED ");
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


  int colPlacePiece = 0;
  public void play()
  {
    turn = 0;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What col would you like to place your piece? ");
    colPlacePiece = keyboard.nextInt();
    if(colPlacePiece < 0 || colPlacePiece > 6)
    {
      System.out.println("You cannot use that col number. Try again later.");
    }
    else
    {
      //the piece needs to fall to the bottom however this code for now
      for(int i = row-1; i >= 0; i--)
      {
        if(grid[i][colPlacePiece] == "null")
        {
          if(turn%2 == 0)
          {
            grid[i][colPlacePiece] = "YELLOW";
            
          }
          else
          {
            grid[i][colPlacePiece] = "RED";
           
          }
        }
      }
    }
    turn++;
    
    
  }

  boolean win = false;
  public boolean checkWin()
  {
    //across
    for(int i = 0; i < row; i++)
    {
      for(int j = 0; j < col - 3; j++)
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
    //up and down
    for(int i2 = 0; i2 < row - 3; i2++)
    {
      for(int j2 = 0; j2 < col; j2++)
      {
        if(grid[i2][j2].equals("RED") && grid[i2+1][j2].equals("RED") && grid[i2+2][j2].equals("RED") && grid[i2+3][j2].equals("RED"))
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

    //diag up
    for(int i3 = 3; i3 < row; i3++)
    {
      for(int j3 = 0; j3 < col-3; j3++)
      {
        if(grid[i3][j3].equals("RED") && grid[i3 - 1][j3+1].equals("RED") && grid[i3-2][j3+2].equals("RED") && grid[i3-3][j3+3].equals("RED"))
        {
          System.out.println("Red wins!");
          win = true;
        }
        if(grid[i3][j3].equals("YELLOW") && grid[i3-1][j3-1].equals("YELLOW") && grid[i3-2][j3-2].equals("YELLOW") && grid[i3-3][j3-3].equals("YELLOW"))
        {
          System.out.println("Yellow wins!");
          win = true;
        }
        
      }
    }
      
      //diag down
    for(int i4 = 0; i4 < row - 3; i4++)
    {
      for(int j4 = 0; j4 < col; j4++)
      {
        if(grid[i4][j4].equals("RED") && grid[i4 - 1][j4+1].equals("RED") && grid[i4-2][j4+2].equals("RED") && grid[i4-3][j4+3].equals("RED"))
        {
          System.out.println("Red wins!");
          win = true;
        }
        if(grid[i4][j4].equals("YELLOW") && grid[i4+1][j4+1].equals("YELLOW") && grid[i4+2][j4+2].equals("YELLOW") && grid[i4+3][j4+3].equals("YELLOW"))
        {
          System.out.println("Yellow wins!");
          win = true;
        }
        
      }

    }

    //end
    return win;
  }





  
}