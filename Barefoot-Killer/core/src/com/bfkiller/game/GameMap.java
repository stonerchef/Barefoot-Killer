package com.bfkiller.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
public class GameMap {
    public Array<Enemy> Enemies;
    public GameMap() {
        Enemies = new Array<>();
        for(int i = 0; i < 1; i++){
            Enemies.add(new Enemy());
        }
    }
    public void draw(SpriteBatch batch){
        batch.begin();
        for (Enemy enemy : Enemies){
            batch.draw(enemy.enemy_img, enemy.hit_box.x, enemy.hit_box.y);
        }
        batch.end();
    }
}
