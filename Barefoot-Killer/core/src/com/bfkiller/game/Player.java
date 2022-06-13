package com.bfkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
    int movementSpeedPerSec;
    int x;
    int y;
    int width;
    int height;
    public Texture player_img;



    public Player(){
        movementSpeedPerSec = 480;
        x = Gdx.graphics.getWidth()/2;
        y = Gdx.graphics.getHeight()/2;
        width = 50;
        height = 100;
    }
    public void moveLeft(OrthographicCamera camera) {
        double delta = Gdx.graphics.getDeltaTime();
        x -= delta*movementSpeedPerSec;
        camera.position.x = x;
        player_img =  new Texture("left.png");
    }
    public void moveRight(OrthographicCamera camera){
        double delta = Gdx.graphics.getDeltaTime();
        x += delta*movementSpeedPerSec;
        camera.position.x = x;
        player_img = new Texture("right.png");
    }
    public void moveUp(OrthographicCamera camera) {
        double delta = Gdx.graphics.getDeltaTime();
        y += delta*movementSpeedPerSec;
        camera.position.y = y;
    }
    public void moveDown(OrthographicCamera camera){
        double delta = Gdx.graphics.getDeltaTime();
        y -= delta*movementSpeedPerSec;
        camera.position.y = y;
    }

}
