import java.util.ArrayList;

public class Lab1Coder {
    private String name;
    int experience;
    private ArrayList<String> languages = new ArrayList<String>();

    Lab1Coder(){
    }
    Lab1Coder(String n ,int exp){
          name = n;
          experience = exp;
    }
    Lab1Coder(String n ){
        name = n;
        experience = 0;
    }
    void setLanguaages(String... lang){
        for (String strlanguages : lang) {
            this.languages.add(strlanguages);
        }
    }
    ArrayList<String> getLanguages() {
        return languages;
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setExperience(int exp){
        experience = exp;
    }

    int getExperience(){
        return experience;
    }

    public String toString(){
        
        String lang = "";
        for (String i : languages){
            lang = lang + i + " ";
        }
        return String.format("%s(%d) know %s" ,name ,experience ,lang);
    }

    ArrayList<String> findCommonLanguages(Lab1Coder other){
        ArrayList<String> match = new ArrayList<>();
        for (String main : this.languages){
            for (String second : other.getLanguages()){
                if (main.equals(second)){
                    match.add(main);
                }
            }
        }
        if (match.isEmpty()){
        match.add("none");
        }
        return match;
    }  
}
