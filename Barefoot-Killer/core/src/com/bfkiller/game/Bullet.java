package com.bfkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class Bullet {
    private  TextureRegion bulletTexture;
    private Enemy target;
    private Rectangle hit_box;
    private float speed;
    private float x_velocity;
    private float y_velocity;
    private float angle;

    public Bullet(Weapon weapon, Array<Enemy> Targets){
        hit_box = new Rectangle();
        hit_box.height = 32;
        hit_box.width = 32;
        hit_box.x = weapon.hit_box.x;
        hit_box.y = weapon.hit_box.y;
        Texture bulletImage = new Texture("bullet.png");
        bulletTexture = new TextureRegion(bulletImage);

        target = getTarget(Targets);

        angle = weapon.angle;

        speed = 100;
        Direction();
    }

    public Enemy getTarget(Array<Enemy> Targets){
        return Targets.get(0);
    }

    private void Direction(){
        float total_movement = 1;
        float x_distance = Math.abs(target.hit_box.x - hit_box.x);
        float y_distance = Math.abs(target.hit_box.y - hit_box.y);
        float total_distance = x_distance + y_distance;
        float x_precent_movement = x_distance / total_distance;
        float y_precent_movement = total_movement - x_precent_movement;

        x_velocity = x_precent_movement;
        y_velocity = y_precent_movement;

        if(target.hit_box.x < hit_box.x){
            x_velocity *= -1;
        }

        if(target.hit_box.y < hit_box.y){
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
        batch.draw(bulletTexture, hit_box.x, hit_box.y,hit_box.width / 2, hit_box.height / 2  , hit_box.width, hit_box.height, 1, 1, angle);
        batch.end();
    }

}
