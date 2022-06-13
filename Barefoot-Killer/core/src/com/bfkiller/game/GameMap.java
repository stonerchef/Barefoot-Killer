package com.bfkiller.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    public void draw(SpriteBatch batch){
        batch.begin();
        for (Enemies monster : monsters){
            batch.draw(monster.enemy_img, monster.posX, monster.posY);
        }
        batch.end();
    }
}
