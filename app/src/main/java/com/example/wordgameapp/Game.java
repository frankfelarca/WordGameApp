package com.example.wordgameapp;

import java.util.Random;

public class Game {

    Random random = new Random();
    String[][] arrayWords;
    String[] correctWords = new String[4];
    int total;
    int score;
    String time;

    public Game(){

    }

    public Game(String[][] arrayWords, String[] correctWords, int total) {
        this.arrayWords = arrayWords;
        this.correctWords = correctWords;
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
