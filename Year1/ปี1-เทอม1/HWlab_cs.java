public class HWlab_cs {
    public static void main(String[] args){
        int [] arr = {1,2,2,2,3,3,3,3};
        int maxCnt = Integer.MIN_VALUE; 
        int mem = arr[0]; 
        int cur = arr[0]; 
        int curCnt =  0; 
        int mode = arr[0]; 

        for (int idx = 1; idx < arr.length; idx++) {
            cur = arr [idx]; 

            if (cur == mem) { 
                curCnt++;    
            } else {
                if (curCnt > maxCnt){ 
                    maxCnt = curCnt; 
                    
                
                }
                curCnt = 1;  
                mem = arr[idx]; 

            }
        }

        if (curCnt > maxCnt) { 
            mode = mem; 
            maxCnt = curCnt; 
        }
        
        System.out.printf("mode = %d Freq = %d%n",mode,maxCnt);
    }
}