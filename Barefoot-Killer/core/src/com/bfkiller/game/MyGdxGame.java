package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input;
public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shape;
	OrthographicCamera camera;
	GameMap map;
	Player player;
	@Override
	public void create () {
		shape = new ShapeRenderer();
		map = new GameMap();
		player = new Player();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.x = player.x;
		camera.position.y = player.y;
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			player.moveLeft(camera);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			player.moveRight(camera);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			player.moveUp(camera);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.moveDown(camera);
		}
		camera.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setProjectionMatrix(camera.combined);
		player.draw(shape);
		map.draw(shape);
		shape.end();
	}
}