package com.bfkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import java.awt.*;

public class Bullet {
    private  TextureRegion bulletTexture;
    private Rectangle target;
    private Rectangle hit_box;
    private float speed;
    private float x_velocity;
    private float y_velocity;
    private float angle;

    public Bullet(Weapon weapon, Array<Enemy> Targets){
        target = new Rectangle();
        target.x = weapon.getTarget(Targets).hit_box.x;
        target.y = weapon.getTarget(Targets).hit_box.y;

        hit_box = new Rectangle();
        hit_box.height = 32;
        hit_box.width = 32;
        hit_box.x = weapon.hit_box.x + weapon.hit_box.width / 2;
        hit_box.y = weapon.hit_box.y + weapon.hit_box.height / 2;

        Texture bulletImage = new Texture("bullet.png");
        bulletTexture = new TextureRegion(bulletImage);

        angle = weapon.angle;
        speed = 2000;
        Direction();
    }
    private void Direction(){
        float total_movement = 1;
        float x_distance = Math.abs(target.x - hit_box.x);
        float y_distance = Math.abs(target.y - hit_box.y);
        float total_distance = x_distance + y_distance;
        float x_precent_movement = x_distance / total_distance;
        float y_precent_movement = total_movement - x_precent_movement;

        x_velocity = x_precent_movement;
        y_velocity = y_precent_movement;

        if(target.x < hit_box.x){
            x_velocity *= -1;
        }

        if(target.y < hit_box.y){
            y_velocity *= -1;
        }

    }

    public void update(){
        float delta = Gdx.graphics.getDeltaTime();
        hit_box.x += x_velocity * speed * delta;
        hit_box.y += y_velocity * speed * delta;
    }

    public void draw(SpriteBatch batch){
        update();
        batch.begin();
        batch.draw(bulletTexture, hit_box.x, hit_box.y,hit_box.width / 2, hit_box.height / 2  , hit_box.width, hit_box.height, 10, 10, angle);
        batch.end();
    }
}