package com.bfkiller.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Iterator;

public class Game extends ApplicationAdapter {
	private ShapeRenderer shape;
	private OrthographicCamera camera;
	private GameMap map;
	private Player player;
	private SpriteBatch batch;
	private Weapon weapon;
	private Array<Bullet> bullets;
	private int timer = 0;
	private Stage stage;
	private HpBar hpBar;
	private Array<Item> items;

	@Override
	public void create () {
		shape = new ShapeRenderer();
		map = new GameMap();
		player = new Player();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		camera.position.x = player.hit_box.x;
		camera.position.y = player.hit_box.y;
		weapon = new Weapon(map.Enemies, player);
		bullets = new Array<Bullet>();
		items = new Array<Item>();

		stage = new Stage();

		hpBar = new HpBar(100, 10);
		hpBar.setPosition(10, Gdx.graphics.getHeight() - 20);
		stage.addActor(hpBar);

	}


	public void kill(){
		for(Bullet bullet : bullets){
			for(Iterator<Enemy> iter = map.Enemies.iterator(); iter.hasNext();){
				Enemy enemy = iter.next();
				if(bullet.hit_box.overlaps(enemy.hit_box)){
					items.add(new Item(enemy));
					iter.remove();
				}
			}
		}
	}

	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
	}


	@Override
	public void render () {

		resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		kill();
		player.hpAcu -= 0.0025f;

		if(timer == 10 && map.Enemies.notEmpty()) {
			bullets.add(new Bullet(weapon, map.Enemies));
			timer = 0;
		}
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyPressed(Input.Keys.A) && player.hit_box.x > map.hit_box.x){
			player.moveLeft(camera);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D) && player.hit_box.x < map.hit_box.x + map.hit_box.width - player.hit_box.width) {
			player.moveRight(camera);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W) && player.hit_box.y < map.hit_box.y + map.hit_box.height - player.hit_box.height){
			player.moveUp(camera);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S) && player.hit_box.y > map.hit_box.y) {
			player.moveDown(camera);
		}

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		map.updateEnemies(player);
		map.draw(batch);

		player.draw(batch, player);
		weapon.draw(batch, map.Enemies);

		for(Bullet bullet : bullets){
			bullet.draw(batch);
		}

		for(Item item : items){
			item.draw(batch);
		}

		//shape.begin(ShapeRenderer.ShapeType.Filled);
		//shape.setProjectionMatrix(camera.combined);
		//shape.end();
		timer++;
		hpBar.setValue(player.hpAcu / player.hpMax);
		stage.draw();
		stage.act();
	}
}
