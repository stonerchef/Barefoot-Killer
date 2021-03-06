package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class Body {

    public Rectangle body;
    private TextureRegion textureRegion;

    public float getX(){
        return body.x;
    }

    public void setX(float x){
        body.x = x;
    }

    public float getY(){
        return body.y;
    }

    public void setY(float y){
        body.y = y;
    }

    public float getWidth(){
        return body.width;
    }

    public void setWidth(float x){
        body.width = x;
    }

    public float getHeight(){
        return body.height;
    }

    public void setHeight(float x){
        body.height = x;
    }

    public void createTextureRegion(String imagePath){
        textureRegion = new TextureRegion(new Texture(imagePath));
    }

    public void createBody(){
        body = new Rectangle();
    }

    public void createBody(float x, float y, float width, float height){
        body = new Rectangle(x, y, width, height);
    }

    public void draw(SpriteBatch batch){
        batch.begin();
        batch.draw(textureRegion, getX(), getY());
        batch.end();
    }

    public void draw(SpriteBatch batch, float x, float y){
        batch.begin();
        batch.draw(textureRegion, x, y);
        batch.end();
    }

    public void draw(SpriteBatch batch, float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY, float angle){
        batch.begin();
        batch.draw(textureRegion, x, y, originX, originY, width, height, scaleX, scaleY, angle);
        batch.end();
    }

}
