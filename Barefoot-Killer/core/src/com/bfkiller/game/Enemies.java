package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Enemies {
    int posX;
    int posY;
    int speedX;
    int speedY;
    int size;
    public Enemies() {
        Random randInt = new Random();
        speedX = 5;
        speedY = 5;
        size = 10;
        posX = randInt.nextInt(Gdx.graphics.getWidth() * 2 ) - Gdx.graphics.getWidth() / 2;
        posY = randInt.nextInt(Gdx.graphics.getHeight() * 2 ) - Gdx.graphics.getHeight() / 2;
    }

    public void update() {
        if(posX <= size || posX >= Gdx.graphics.getWidth() - size) speedX *= -1;
        if(posY <= size || posY >= Gdx.graphics.getHeight() - size) speedY *= -1;
        posX += speedX;
        posY += speedY;
    }
    public void moveLeft() {
        posX -= 5;
    }
    public void moveRight(){
        posX += 5;
    }
    public void moveTop() {
        posY += 5;
    }
    public void moveBot(){
        posY -= 5;
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(posX, posY, size);
    }
}
