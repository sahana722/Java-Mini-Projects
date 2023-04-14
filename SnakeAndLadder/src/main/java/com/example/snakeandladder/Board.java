package com.example.snakeandladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCoordinates;
    ArrayList<Integer> snakeAndLadderPosition;

    public Board(){
        positionCoordinates = new ArrayList<>();
        populationPositionCoordinates();
        populateSnakeLadder();
    }

    private void populationPositionCoordinates(){
        positionCoordinates.add(new Pair<>(0,0)); //dummy value
        for (int i = 0; i < SnakeAndLadder.height; i++) {
            for(int j=0; j<SnakeAndLadder.width;j++){
                //x co-ordinates
                int xCord = 0;
                if(i%2==0){
                    xCord = j*SnakeAndLadder.tileSize + SnakeAndLadder.tileSize/2;
                }
                else{
                    xCord = SnakeAndLadder.tileSize * SnakeAndLadder.height - (j*SnakeAndLadder.tileSize)-SnakeAndLadder.tileSize/2;
                }
                //y co-ordinates
                int yCord = SnakeAndLadder.tileSize * SnakeAndLadder.height - (i*SnakeAndLadder.tileSize)-SnakeAndLadder.tileSize/2;
                positionCoordinates.add(new Pair<>(xCord,yCord));
            }
        }
    }

    private  void populateSnakeLadder(){
        snakeAndLadderPosition=new ArrayList<>();
        for (int i = 0; i < 101 ; i++) {
            snakeAndLadderPosition.add(i);
        }
        snakeAndLadderPosition.set(2,45);
        snakeAndLadderPosition.set(4,27);
        snakeAndLadderPosition.set(9,31);
        snakeAndLadderPosition.set(16,8);
        snakeAndLadderPosition.set(47,84);
        snakeAndLadderPosition.set(52,28);

        snakeAndLadderPosition.set(70,87);
        snakeAndLadderPosition.set(71,91);
        snakeAndLadderPosition.set(78,25);
        snakeAndLadderPosition.set(93,89);
        snakeAndLadderPosition.set(95,75);
        snakeAndLadderPosition.set(99,21);

    }

    public int getNewPosition(int currentPosition){
        if(currentPosition>0 && currentPosition<=100){
            return snakeAndLadderPosition.get(currentPosition);
        }
        return -1;
    }

    int getXCoordinate(int position){
        if(position>=1 && position <=100)
            return positionCoordinates.get(position).getKey();
        return -1;
    }

    int getYCoordinate(int position){
        if(position>=1 && position <=100)
            return positionCoordinates.get(position).getValue();
        return -1;
    }


   // public static void main(String[] args) {
     //   Board board = new Board();
      //  for (int i = 0; i < board.positionCoordinates.size() ; i++) {
      //      System.out.println(i + " $ x :" + board.positionCoordinates.get(i).getKey() +
       //             "  y : " + board.positionCoordinates.get(i).getValue()
       //             );

     //   }
   // }
}
