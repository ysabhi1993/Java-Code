package com.abhishek;

import java.util.ArrayList;

public class Team<E extends Player> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<E> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(E player){
        if(members.contains(player)){
            System.out.println("Player " + (player).getName() + " already present");
            return true;
        } else {
            members.add(player);
            System.out.println("Player " + (player).getName() + " added");
            return false;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<E> opponent, int ourScore, int theirScore){
        if(ourScore > theirScore) won++;
        else if(ourScore == theirScore) tied++;
        else lost++;
        played++;
        if(opponent != null){
            opponent.matchResult(null, theirScore,ourScore);
        }
    }

    public int ranking(){
        return won * 2 + tied;
    }
}
