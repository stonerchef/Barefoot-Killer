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

    private Enemy getTarget(){
        return Targets.get(0);
    }

    private float calculateAngle(Player player){
        double angleTemp = Math.atan2(target.hit_box.y - player.hit_box.y, target.hit_box.x - player.hit_box.x);
        return (float) Math.toDegrees(angleTemp);
    }

    public void draw(SpriteBatch batch, Player player, Array<Enemy> Targets){
        weapon.x = player.hit_box.x + (float)1.5 * player.hit_box.width;
        weapon.y = player.hit_box.y + player.hit_box.height / 2;
        this.Targets = Targets;
        target = getTarget();
        float angle = calculateAngle(player);
        batch.begin();
        batch.draw(weaponTexture, weapon.x, weapon.y,weapon.width / 2, weapon.height / 2  , weapon.width, weapon.height, 1, 1, angle);
        batch.end();
    }




}
