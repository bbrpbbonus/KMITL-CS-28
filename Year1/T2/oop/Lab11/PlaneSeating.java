public abstract class PlaneSeating{
    protected String planeType;
    protected char[][] seating;
    public int length;

    public void showSeating(){
        for (int i = 0; i < seating.length; i++) {
            System.out.print("row"+(i+1)+" --> ");
            for (int j = 0; j < seating[i].length; j++) {
                System.out.print(seating[i][j]);
            }
            System.out.println();
        }
    }
    public abstract boolean reserveSeat(int row ,int col);
}
