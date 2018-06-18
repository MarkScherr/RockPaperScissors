/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Random;

/**
 *
 * @author mrsch
 */
public class Game {
    private int playerWins, playerLosses,  playerDraws;
    private int npcWins, npcLosses, npcDraws;
    private int gamesToPlay;
    private int playerRoundsWon, npcRoundsWon;
    private String npcSelection;
    private UserInput userInput = new UserInput();
    
    public Game() {
        
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getPlayerLosses() {
        return playerLosses;
    }

    public void setPlayerLosses(int playerLosses) {
        this.playerLosses = playerLosses;
    }

    public int getPlayerDraws() {
        return playerDraws;
    }

    public void setPlayerDraws(int playerDraws) {
        this.playerDraws = playerDraws;
    }

    public int getNpcWins() {
        return npcWins;
    }

    public void setNpcWins(int npcWins) {
        this.npcWins = npcWins;
    }

    public int getNpcLosses() {
        return npcLosses;
    }

    public void setNpcLosses(int npcLosses) {
        this.npcLosses = npcLosses;
    }

    public int getNpcDraws() {
        return npcDraws;
    }

    public void setNpcDraws(int npcDraws) {
        this.npcDraws = npcDraws;
    }
    
    public int getPlayerRoundsWon () {
        return playerRoundsWon;
    }
    
    public int getNpcRoundsWon () {
        return npcRoundsWon;
    }
    //game play 
    public void playGame() {
        userInput.askGames();
        gamesToPlay = userInput.getGames();
        String playerChoice;
        //reset the NPC and users win loss draw
        setPlayerWins(0);
        setPlayerLosses(0);
        setPlayerDraws(0);
        
        setNpcWins(0);
        setNpcLosses(0);
        setNpcDraws(0);
        
        
        for (int i = 0 ; i < gamesToPlay ; i++) {
            userInput.askSelection();
            playerChoice = userInput.getSelection();
            npcChoice();
            System.out.println("I chose: " + npcSelection); 
            //checks for tie
            if (playerChoice.equals(npcSelection)) {
                npcDraws++;
                playerDraws++;
                System.out.println("You tied with me this time, don't worry you"
                        + " will not match my skills that often.");
                //checks for player win
            } else if (playerChoice.equals("ROCK") && npcSelection.equals("SCISSOR") ||
                    playerChoice.equals("SCISSOR") && npcSelection.equals("PAPER") ||
                    playerChoice.equals("PAPER") && npcSelection.equals("ROCK")) {
                playerWins++;
                npcLosses++;
                System.out.println("You lucky punk, I'll get you next time!");
            } 
            //rest of results will mean NPC win
            else {
                playerLosses++;
                npcWins++;
                System.out.println("You lose! Please put 1 WIN for me and one LOSS for you");
            }
                  
            System.out.println("\nPlayer: Wins = " + playerWins + ", Losses = " + 
                    playerLosses + ", Draws = " + playerDraws);
            System.out.println("NPC: Wins = " + npcWins + ", Losses = " + 
                    npcLosses + ", Draws = " + npcDraws + "\n");
            
        }
        endOfRound(playerWins,npcWins);
        System.out.println("Rounds: Player = " + playerRoundsWon + ", NPC = " 
                    + npcRoundsWon);
        
        if (userInput.playAgain()) {
            playGame();
        } else {
            if (playerRoundsWon > npcRoundsWon) {
                System.out.println("You beat me overall, maybe I should "
                        + "reconsider my strategy.");
            } else if (playerRoundsWon < npcRoundsWon) {
                System.out.println("That was easy as pie crushing you in all "
                        + "those rounds, you should come \nback some day when you "
                        + "can actually compete with me.");
            } else {
                System.out.println("You can't finish now, neither of us won! \nI "
                        + "guess you just can't handle my mad skills!");
            }
            System.out.println("Goodbye Punk!");
        }
    }
    //keeps track of round wins 
    public void endOfRound(int playerWins, int npcWins) {
        if (playerWins > npcWins) {
            playerRoundsWon++;
        } else if (playerWins == npcWins){
            return;
        } else {
            npcRoundsWon++;
        }
            
    }
    //calculates a random number for the NPC choice 
    public void npcChoice () {
        int numericalChoice = 0;
        
        Random rdm = new Random();
        numericalChoice = rdm.nextInt(3) + 1;
        
        switch (numericalChoice) {
            case 1: npcSelection = "ROCK";
                    break;
            case 2: npcSelection = "PAPER";
                    break;
            case 3: npcSelection = "SCISSOR";        
                    break;        
                          
        }

    }
}
