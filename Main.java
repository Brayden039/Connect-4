class Main
  {
  public static void main(String[] args)
  {
    Board b1 = new Board();
    b1.printGrid();
    b1.play();
    b1.printGrid();
    b1.checkWin();
  }
}