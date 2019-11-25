package com.example.hidden;

import java.util.ArrayList;

public class Game {
    private int image;
    private String answer;
    private String[] choice;

    public Game(int image, String answer, String[] choice) {
        this.image = image;
        this.answer = answer;
        this.choice = choice;
    }

    public static ArrayList<Game> createGame() {
        ArrayList<Game> gameArrayList = new ArrayList<>();
        String[] choice = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice));

        String[] choice2 = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice2));

        String[] choice3 = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice3));

        String[] choice4 = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice4));

        String[] choice5 = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice5));

        String[] choice6 = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice6));

        String[] choice7 = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice7));

        String[] choice8 = {"Fish", "Dog"};
        gameArrayList.add(new Game(R.drawable.btnbird, "Bird", choice8));


        return gameArrayList;
    }

    public String[] getChoice() {
        return choice;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
