package com.bfkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.MathUtils;
import java.util.Random;

public class Enemy {
    public Rectangle hit_box;
    float movementSpeedPreSec;
    public Texture enemy_img;
    public Enemy() {
        hit_box = new Rectangle();
        Random randInt = new Random();
        movementSpeedPreSec = 60;
        hit_box.width = 64;
        hit_box.height = 64;
        hit_box.x = randInt.nextInt(Gdx.graphics.getWidth() * 2 ) - Gdx.graphics.getWidth() / 2;
        hit_box.y = randInt.nextInt(Gdx.graphics.getHeight() * 2 ) - Gdx.graphics.getHeight() / 2;
        enemy_img = new Texture("left_enemy.png");
    }

    public void goToTarget(Player target){
        float delta = Gdx.graphics.getDeltaTime();
        double angle = Math.atan2(target.hit_box.y - this.hit_box.y, target.hit_box.x - this.hit_box.x);
        this.hit_box.x += Math.cos(angle) * movementSpeedPreSec * delta;
        this.hit_box.y += Math.sin(angle) * movementSpeedPreSec * delta;
    }
}