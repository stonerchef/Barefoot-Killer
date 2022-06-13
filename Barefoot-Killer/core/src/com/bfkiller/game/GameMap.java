package com.bfkiller.game;

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
}
