package com.bfkiller.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
public class GameMap {
    private final TextureRegion mapTexture;
    public Rectangle hit_box;
    public Array<Enemy> Enemies;
    public GameMap() {
        Texture mapImage = new Texture("map.png");
        mapTexture = new TextureRegion(mapImage);

        int width = 1600;
        int heigth = 800;
        hit_box = new Rectangle(0, 0, width, heigth);

        Enemies = new Array<>();
        for(int i = 0; i < 5; i++){
            Enemies.add(new Enemy());
        }
    }
    public void  updateEnemies(Player target){
        for (Enemy enemy : Enemies){
            enemy.goToTarget(target);
        }
    }
    public void draw(SpriteBatch batch){
        batch.begin();
        batch.draw(mapTexture, hit_box.x, hit_box.y,hit_box.width / 2, hit_box.height / 2  ,
                hit_box.width, hit_box.height, 1, 1, 0);
        for (Enemy enemy : Enemies){
            batch.draw(enemy.enemy_img, enemy.hit_box.x, enemy.hit_box.y);
        }
        batch.end();
    }
}
