package com.bfkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Enemies {
    int posX;
    int posY;
    int movementSpeedPreSec;
    int size;
    public Texture enemy_img;
    public Enemies() {
        Random randInt = new Random();
        movementSpeedPreSec = 240;
        size = 10;
        posX = randInt.nextInt(Gdx.graphics.getWidth() * 2 ) - Gdx.graphics.getWidth() / 2;
        posY = randInt.nextInt(Gdx.graphics.getHeight() * 2 ) - Gdx.graphics.getHeight() / 2;
        enemy_img = new Texture("left_enemy.png");
    }

}