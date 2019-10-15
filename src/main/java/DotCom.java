import java.util.ArrayList;

class DotCom {
    private ArrayList<String> dotCom;
    private String name;

    void setLocation(ArrayList<String> dotCom){
        this.dotCom = dotCom;
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    String checkYourself(String guess){
        if (!dotCom.contains(guess)) return "miss";

        dotCom.remove(dotCom.indexOf(guess));
        if (dotCom.isEmpty()) {
            return "kill";
        } else {
            return "hit";
        }
    }
}
