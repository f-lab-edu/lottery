package app.src.main.java.org.example.domain;

import app.src.main.java.org.example.constant.Rank;

import java.util.*;

public class Result {

    private final List<Rank> results = new ArrayList<>();
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public Result() {
        Arrays.stream(Rank.values())
                .forEach(v -> rankCount.put(v, 0));
    }

    public void add(Rank rank) {
        results.add(rank);
        updateRankCount(rank);
    }

    public double getProfit() {
        System.out.println( results.stream()
                .mapToInt(Rank::getMoney)
                .sum());
        return  round(results.stream()
                .mapToDouble(Rank::getMoney)
                .sum() , (double) results.size()*1000)
             ;
    }

    private double round(double sum, double amt){
        return Math.round((sum/amt)*100)/100.00;
    }

    public List<Rank> getResult() {
        return results;
    }

    public void updateRankCount(Rank rank) {
       rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public Integer getRankCount(Rank rank) {
        return rankCount.get(rank);
    }

}
