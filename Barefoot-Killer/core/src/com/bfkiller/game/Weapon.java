package com.bfkiller.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Weapon {
    private final TextureRegion weaponTexture;
    private Enemy target;
    public Rectangle hit_box;
    public float angle;

    public Weapon(Array<Enemy> Targets, Player player){
        hit_box = new Rectangle();
        hit_box.width = 64;
        hit_box.height = 64;
        Texture weaponImage = new Texture("weapon.png");
        weaponTexture = new TextureRegion(weaponImage);
        hit_box.x = player.hit_box.x + (float)1.5 * player.hit_box.width;
        hit_box.y = player.hit_box.y + player.hit_box.height / 2;
        target = getTarget(Targets);
        angle = calculateAngle(player);

    }

    private Enemy getTarget(Array<Enemy> Targets){
        return Targets.get(0);
    }

    private float calculateAngle(Player player){
        double angleTemp = Math.atan2(target.hit_box.y - player.hit_box.y, target.hit_box.x - player.hit_box.x);
        return (float) Math.toDegrees(angleTemp);
    }

    public void draw(SpriteBatch batch, Player player, Array<Enemy> Targets){
        hit_box.x = player.hit_box.x + (float)1.5 * player.hit_box.width;
        hit_box.y = player.hit_box.y + player.hit_box.height / 2;
        target = getTarget(Targets);
        angle = calculateAngle(player);
        batch.begin();
        batch.draw(weaponTexture, hit_box.x, hit_box.y,hit_box.width / 2, hit_box.height / 2  , hit_box.width, hit_box.height, 1, 1, angle);
        batch.end();
    }




}
