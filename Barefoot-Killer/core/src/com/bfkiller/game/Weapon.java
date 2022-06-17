package com.bfkiller.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Weapon {
    private final TextureRegion weaponTexture;
    private Array<Enemy> Targets;
    private Enemy target;
    private final Rectangle weapon;

    public Weapon(Array<Enemy> Targets){
        this.Targets = Targets;
        weapon = new Rectangle();
        weapon.width = 64;
        weapon.height = 64;
        Texture weaponImage = new Texture("weapon.png");
        weaponTexture = new TextureRegion(weaponImage);
    }

    private Enemy getTarget(Player player){
        double val_min = 0;
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

    private float calculateAngle(Player player){
        double angleTemp = Math.atan2(target.hit_box.y - player.hit_box.y, target.hit_box.x - player.hit_box.x);
        return (float) Math.toDegrees(angleTemp);
    }

    public void draw(SpriteBatch batch, Player player, Array<Enemy> Targets){
        weapon.x = player.hit_box.x + (float)1.5 * player.hit_box.width;
        weapon.y = player.hit_box.y + player.hit_box.height / 2;
        this.Targets = Targets;
        target = getTarget(player);
        float angle = calculateAngle(player);
        batch.begin();
        batch.draw(weaponTexture, weapon.x, weapon.y,weapon.width / 2, weapon.height / 2  , weapon.width, weapon.height, 1, 1, angle);
        batch.end();
    }




}
