public class Plane22Seating extends PlaneSeating {
    private int row;
    private int col;

    private boolean isFull(){
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[i].length; j++) {
                if (seating[row][col] == '^') {
                    return false;
                }
            }
        }
        return true;
    } 

    public Plane22Seating (String args){
        super();
        String [] token = args.split(",");
        int numRow = token.length;
        int numCol = token[0].length();
        seating = new char[numRow][numCol];
        for (int i = 0; i < token.length; i++){
            seating[i] = token[i].toCharArray();
        }
    }

    public boolean reserveSeat(int row ,int col){
        boolean reserved = false;
        if(seating[row-1][col-1] == '^'){
            seating[row-1][col-1] = 'x';
            reserved = true;
            System.out.println("seat "+(row-1)+" "+(col-1)+" symbol is ^. Latest seat map is");
        }
        showSeating();
        return reserved;
    }
    
}
