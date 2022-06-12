package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;
public class GameMap {
    ArrayList<Enemies> monsters;
    public GameMap() {
        monsters = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            monsters.add(new Enemies());
        }
    }
    public void draw(ShapeRenderer shape){
        for (Enemies monster : monsters){
            monster.draw(shape);
        }
    }

    public void moveLeft()
    {
        for (Enemies monster : monsters){
            monster.moveRight();
        }
    }
    public void moveRight()
    {
        for (Enemies monster : monsters){
            monster.moveLeft();
        }
    }
    public void moveTop()
    {
        for (Enemies monster : monsters){
            monster.moveBot();
        }
    }
    public void moveBot()
    {
        for (Enemies monster : monsters){
            monster.moveTop();
        }
    }
}
