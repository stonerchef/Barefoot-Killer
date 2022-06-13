package com.bfkiller.game;

import com.badlogic.gdx.Gdx;
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
    public Enemies() {
        Random randInt = new Random();
        movementSpeedPreSec = 240;
        size = 10;
        posX = randInt.nextInt(Gdx.graphics.getWidth() * 2 ) - Gdx.graphics.getWidth() / 2;
        posY = randInt.nextInt(Gdx.graphics.getHeight() * 2 ) - Gdx.graphics.getHeight() / 2;
    }
    public void draw(ShapeRenderer shape) {
        shape.circle(posX, posY, size);
    }
}
}
