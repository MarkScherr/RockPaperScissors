/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Scanner;

/**
 *
 * @author mrsch
 */
public class UserInput {
    private int games;
    private String selection;
   
    
    public UserInput() {
        
    }
    public void setGames(int rounds) {
        this.games = rounds;
    }
    public int getGames() {
        return games;
    }
    public void setSelection(String selection) {
        this.selection = selection;
    }
    public String getSelection() {
        return selection;
    }
    //asks the user how many games they want to play this round
    public void askGames() {
        Scanner input = new Scanner(System.in);
        String stringRounds = "";
        System.out.println("How many games did you want to play this round? (1-10)");
        stringRounds = input.nextLine();
        games = Integer.parseInt(stringRounds);
        
        if (games > 10 || games < 1) {
            System.out.println("You entered the wrong amount!!!!!!!!!!!!!!!");
            System.exit(0);
        }

    }
    
    public void askSelection() {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to choose? ROCK, "
                + "PAPER or SCISSOR (if you can't spell, then I win)");
        selection = input.nextLine();
        selection = selection.toUpperCase();
        
    }
    public boolean playAgain() {
        Scanner input = new Scanner(System.in);
        String response = "";
        System.out.println("Play Again? (Y/N)");
        response = input.nextLine();
        response = response.toUpperCase();
        return response.equals("Y");
    }
    

}
