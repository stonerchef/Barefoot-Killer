package com.bfkiller.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import java.lang.Math;
public class Weapon {
    private final TextureRegion weaponTexture;
    Player player;
    private Enemy target;
    public Rectangle hit_box;
    public float angle;
    public Weapon(Array<Enemy> Targets, Player p){
        player = p;
        hit_box = new Rectangle();
        hit_box.width = 64;
        hit_box.height = 64;
        Texture weaponImage = new Texture("weapon.png");
        weaponTexture = new TextureRegion(weaponImage);
        hit_box.x = p.hit_box.x + (float)1.5 * p.hit_box.width;
        hit_box.y = p.hit_box.y + p.hit_box.height / 2;
        target = getTarget(Targets);
        angle = calculateAngle();
    }
    public Enemy getTarget(Array<Enemy> Targets){
        double val_min = Integer.MAX_VALUE;
        int index_min = 0;
        int i = 0;
        for (Enemy enemy : Targets){
            double temp = Math.pow(enemy.hit_box.x - player.hit_box.x, 2) +
                    Math.pow(enemy.hit_box.y - player.hit_box.y, 2);
            if(temp < val_min){
                val_min = temp;
                index_min = i;
            }
            i++;
        }
        return Targets.get(index_min);
    }
    private float calculateAngle(){
        double angleTemp = Math.atan2(target.hit_box.y - player.hit_box.y, target.hit_box.x - player.hit_box.x);
        return (float) Math.toDegrees(angleTemp);
    }
    public void draw(SpriteBatch batch, Array<Enemy> Targets){
        hit_box.x = player.hit_box.x + (float)1.5 * player.hit_box.width;
        hit_box.y = player.hit_box.y + player.hit_box.height / 2;
        target = getTarget(Targets);
        angle = calculateAngle();
        batch.begin();
        batch.draw(weaponTexture, hit_box.x, hit_box.y,hit_box.width / 2, hit_box.height / 2  , hit_box.width, hit_box.height, 1, 1, angle);
        batch.end();
    }
}
