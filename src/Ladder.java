import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Ladder {
    private int numberOfPeople;
    private int heightOfLadder;
    private List<List<Character>> charLadder;

    Ladder(int n, int m) {
        this.numberOfPeople = n;
        this.heightOfLadder = m;
        this.init();
    }

    private void init() {
        this.charLadder = make();
    }

    private List<List<Character>> make() {
        List<List<Character>> ladder = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(makeRow());
        }
        return ladder;
    }

    private List<Character> makeRow() {
        List<Character> rowOfLadder = new ArrayList<>();
        for (int i = 0; i < numberOfPeople-1; i++) {
            rowOfLadder.add(setRandomValue());
        }
        return rowOfLadder;
    }

    private char setRandomValue() {
        Random rand = new Random();
        int temp = rand.nextInt(2); // 0, 1 중 하나의 값
        if (temp==0){
            return ' ';
        }
        return '-';
    }

    public String Info() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heightOfLadder; i++) {
            sb.append(rowOfLadderInfo(i));
        }

        return sb.toString();
    }

    private String rowOfLadderInfo(int index) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for(int i=0; i<numberOfPeople-1; i++){
            sb.append(charLadder.get(index).get(i));
            sb.append("|");
        }
        sb.append("\n");
        return sb.toString();
    }



}

