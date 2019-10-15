import java.util.ArrayList;

class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private ArrayList<String> guesses = new ArrayList<String>();

    void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Google.com");
        DotCom two = new DotCom();
        two.setName("Apple.com");
        DotCom three = new DotCom();
        three.setName("Facebook.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);
        for (DotCom dotCom : dotComList){
            dotCom.setLocation(helper.placeDotCom(3));
        }
        startPlaying();
    }

    private void startPlaying(){
        while(!dotComList.isEmpty()){
            String guess = helper.getUserInput("Enter a guess, a0 - f6: ");
            checkUserGuess(guess);
        }
        finishGame();
    }

    private void checkUserGuess(String stringGuess){
        String result = "";
        String killed = "";
        DotCom killedDotCom = null;
        if (guesses.contains(stringGuess)) result = "Already guessed, try again";
        guesses.add(stringGuess);
        for (DotCom dotCom : dotComList){
            String checkResult = dotCom.checkYourself(stringGuess);
            if (checkResult.equals("hit")) result = checkResult;
            if (checkResult.equals("kill")){
                result = checkResult;
                killed = dotCom.getName();
                killedDotCom = dotCom;
            }
        }
        if (killedDotCom != null) dotComList.remove(killedDotCom);

        if (result.equals("")) result = "miss";

        if (!result.equals("kill"))
            System.out.println(result);
        else System.out.println("Congratulations! You killed " + killed);
    }

    private void finishGame(){
        System.out.println("Congratulations, you win! You made " + guesses.size() + " unique guesses.");
    }
}
