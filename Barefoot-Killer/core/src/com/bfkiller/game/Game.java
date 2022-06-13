package com.bfkiller.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input;
public class Game extends ApplicationAdapter {
	private ShapeRenderer shape;
	private OrthographicCamera camera;
	private GameMap map;
	private Player player;
	private SpriteBatch batch;
	@Override
	public void create () {
		shape = new ShapeRenderer();
		map = new GameMap();
		player = new Player();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		camera.position.x = player.x;
		camera.position.y = player.y;
		player.player_img = new Texture("right_player.png");
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

		map.draw(batch);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(player.player_img, player.x, player.y);
		batch.end();


		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setProjectionMatrix(camera.combined);
		shape.end();
	}
}
