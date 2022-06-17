package com.bfkiller.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Enemy {
    public Rectangle hit_box;
    int movementSpeedPreSec;
    public Texture enemy_img;
    public Enemy() {
        hit_box = new Rectangle();
        Random randInt = new Random();
        movementSpeedPreSec = 240;
        hit_box.width = 64;
        hit_box.height = 64;
        hit_box.x = 64; //randInt.nextInt(Gdx.graphics.getWidth() * 2 ) - Gdx.graphics.getWidth() / 2;
        hit_box.y = 64; //randInt.nextInt(Gdx.graphics.getHeight() * 2 ) - Gdx.graphics.getHeight() / 2;
        enemy_img = new Texture("left_enemy.png");
    }

}