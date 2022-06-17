package com.bfkiller.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


public class Bullet {
    private  TextureRegion bulletTexture;
    private Enemy target;
    private Rectangle hit_box;
    private float speed;

    public Bullet(){
        hit_box = new Rectangle();
        hit_box.height = 64;
        hit_box.width = 64;
        Texture bulletImage = new Texture("bullet.png");
        bulletTexture = new TextureRegion(bulletImage);
    }

}
