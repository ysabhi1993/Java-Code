package com.abhishek;

public class Main {
    //Generics are like C++ templates
    // The argument passed for the type parameter can be a class or an interface
    // If the argument can be of type of a class and an interface, the class has to be specified first
    public static void main(String[] args) {
	    FootballPlayer joe = new FootballPlayer("Joe");
	    BaseballPlayer pat = new BaseballPlayer("Pat");
	    SoccerPlayer beckham = new SoccerPlayer("Beckham");

	    Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");

	    adelaideCrows.addPlayer(joe);
	    //adelaideCrows.addPlayer(pat);
	    //adelaideCrows.addPlayer(beckham);

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago cubs");
        baseballTeam.addPlayer(pat);
    }
}
