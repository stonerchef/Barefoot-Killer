package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final MainGame game;

    OrthographicCamera camera;

    private Player player;
    private Array<Enemy> enemies;
    private Weapon weapon;

    public enum State{
        PAUSE,
        RUN,
        STOPPED
    }

    private State state = State.RUN;

    public GameScreen(MainGame game) {
        this.game = game;

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        player = new Player();
        weapon = new Weapon(player);
        enemies = new Array<>();
        for (int i = 0; i < 10; i++){ enemies.add(new Enemy());}
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        switch (state){
            case RUN:
                update(delta);
                draw();
                break;
            case PAUSE:
                pause();
                break;
            case STOPPED:
                Gdx.app.exit();
                break;
            default:
                break;
        }

    }

    public void update(float delta){
        ScreenUtils.clear(0, 0, 0.25f,1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        for (Enemy enemy : enemies){
            enemy.update(player);
        }
        weapon.update(enemies);

        inputHandler(delta);
    }

    public void draw(){
        player.draw(game.batch);
        weapon.draw(game.batch);
        for (Enemy enemy : enemies){
            enemy.draw(game.batch);
        }
    }

    public void setGameState(State state){
        this.state = state;
    }

    public void inputHandler(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            player.moveLeft(camera, delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.moveRight(camera, delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            player.moveUp(camera, delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.moveDown(camera, delta);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            setGameState(State.PAUSE);
        }
    }

    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        setGameState(State.PAUSE);
        game.setScreen(new PauseScreen(game, this));
    }

    @Override
    public void resume() {
        setGameState(State.RUN);
        game.setScreen(this);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
