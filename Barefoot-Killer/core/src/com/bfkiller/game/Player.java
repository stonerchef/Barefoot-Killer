package com.bfkiller.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private final float movementSpeedPerSec;
    public Rectangle hit_box;
    private Texture player_img;
    int hp;


    public Player(){
        hit_box = new Rectangle();
        movementSpeedPerSec = 480 / 2;
        hit_box.x = Gdx.graphics.getWidth()/2;
        hit_box.y = Gdx.graphics.getHeight()/2;
        hit_box.width = 64;
        hit_box.height = 64;
        player_img = new Texture("right_player.png");
    }

    public void moveLeft(OrthographicCamera camera) {
        double delta = Gdx.graphics.getDeltaTime();
        hit_box.x -= delta*movementSpeedPerSec;
        camera.position.x = hit_box.x;
        player_img =  new Texture("left_player.png");
    }
    public void moveRight(OrthographicCamera camera){
        double delta = Gdx.graphics.getDeltaTime();
        hit_box.x += delta*movementSpeedPerSec;
        camera.position.x = hit_box.x;
        player_img = new Texture("right_player.png");
    }
    public void moveUp(OrthographicCamera camera) {
        double delta = Gdx.graphics.getDeltaTime();
        hit_box.y += delta*movementSpeedPerSec;
        camera.position.y = hit_box.y;
    }
    public void moveDown(OrthographicCamera camera){
        double delta = Gdx.graphics.getDeltaTime();
        hit_box.y -= delta*movementSpeedPerSec;
        camera.position.y = hit_box.y;
    }
    public void draw(SpriteBatch batch, Player player){
        player_img = new Texture("hit_boxplayer.png");
        batch.begin();
        batch.draw(player.player_img, hit_box.x, hit_box.y);
        batch.end();
    }
}