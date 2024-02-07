public class Lab5Q4_265492{
    public static void main(String[] args){
        String s1 = "I am happy";
        String s2 = "xyz";
        s1 = s1.toLowerCase();
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) == 'a' || s1.charAt(i) == 'e' ||s1.charAt(i) == 'i' ||s1.charAt(i) == 'o' || s1.charAt(i) == 'u'){               
                System.out.println(i);
                break;
            }
            if(i == s1.length()-1){
                System.out.println(-1);
                break;
            }
        }
        for (int j = 0; j < s2.length(); j++){
            if(s2.charAt(j) == 'a' || s2.charAt(j) == 'e' ||s2.charAt(j) == 'i' ||s2.charAt(j) == 'o' || s2.charAt(j) == 'u'){               
                System.out.println(j);
                break;  
            }
            if(j == s2.length()-1){
                System.out.println("-1");
                break;
            }
            
        }

    }
}