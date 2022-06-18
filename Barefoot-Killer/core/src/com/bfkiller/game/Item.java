package com.bfkiller.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class Item {
    public Rectangle hit_box;
    public Texture item_image;


    public Item(Enemy enemy){

        hit_box = new Rectangle(enemy.hit_box.x, enemy.hit_box.y, 4, 4);
        item_image = new Texture("item.png");
    }

    public void draw(SpriteBatch batch){
        batch.begin();
        batch.draw(item_image, hit_box.x, hit_box.y);
        batch.end();
    }


}
