package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Line> ladder;
    private List<String> players;
    private List<String> results;

    public Game(Ladder ladder){
        this.ladder = ladder.getLadderInfo();
        this.players = ladder.getPlayersInfo();
        this.results = ladder.getResultsInfo();
    }

    public String play(String player){
        return getAllPlayersResults().get(player);
    }

    private GamePlayResults getAllPlayersResults(){
        Map<String, String> gameResults = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            gameResults.put(players.get(i), getOnePlayerResult(i));
        }
        return new GamePlayResults(gameResults);
    }

    private String getOnePlayerResult(int nowPlayerIndex) {
        return results.get(stepDown(nowPlayerIndex));
    }

    private int stepDown(int nowPlayerIndex){
        for (int i = 0; i < ladder.size(); i++) {
            nowPlayerIndex = rowCheck(nowPlayerIndex, i);
        }
        return nowPlayerIndex;
    }

    private int rowCheck(int playerIndex, int step){
        if(leftSideCheck(playerIndex, step)){
            return resetPlayerIndexByLeftSide(playerIndex, step);
        }
        if(rightSideCheck(playerIndex, step)){
            return resetPlayerIndexByRightSide(playerIndex, step);
        }
        return playerIndex;
    }

    private boolean leftSideCheck(int playerIndex, int step){
        int i = playerIndex;
        while(i > 0 && isLine(i, step)){    // 맨 왼쪽 인덱스를 제외하고, 라인이 있는지 확인
            i--;
        }
        return (i!=playerIndex);
    }

    private boolean rightSideCheck(int playerIndex, int step){
        int index = playerIndex+1;
        while(index <= ladder.get(step).size() && isLine(index, step)){ // 맨 오른쪽 인덱스를 제외하고, 라인이 있는지 확인
            index++;
        }
        return (index !=playerIndex+1);
    }

    private boolean isLine(int index, int step){
        return ladder.get(step).get(index-1);
    }

    private int resetPlayerIndexByLeftSide(int playerIndex, int step){
        int index = playerIndex;
        while(index > 0 && isLine(index, step)){
            index--;
        }
        return index;
    }

    private int resetPlayerIndexByRightSide(int playerIndex, int step){
        int index = playerIndex+1;
        while(index <= ladder.get(step).size() && isLine(index, step)){
            index++;
        }
        return index-1;
    }
}
