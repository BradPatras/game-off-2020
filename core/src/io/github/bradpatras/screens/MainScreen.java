package io.github.bradpatras.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import io.github.bradpatras.B2dContactListener;
import io.github.bradpatras.TranslunarGame;
import io.github.bradpatras.controller.KeyboardController;
import io.github.bradpatras.entity.systems.AnimationSystem;
import io.github.bradpatras.entity.systems.CollisionSystem;
import io.github.bradpatras.entity.systems.PhysicsDebugSystem;
import io.github.bradpatras.entity.systems.PhysicsSystem;
import io.github.bradpatras.entity.systems.PlayerControlSystem;
import io.github.bradpatras.entity.systems.RenderingSystem;

public class MainScreen implements Screen {
    private World world;
    private TranslunarGame parent;
    private KeyboardController controller;
    private Engine engine;

    public MainScreen(TranslunarGame translunarGame) {
        parent = translunarGame;
        controller = new KeyboardController();
        world = new World(new Vector2(0,-10f), true);
        world.setContactListener(new B2dContactListener());
        bodyFactory = BodyFactory.getInstance(world);

        parent.assetManager.queueAddSounds();
        parent.assetManager.manager.finishLoading();
        atlas = parent.assetManager.manager.get("images/game.atlas", TextureAtlas.class);
        ping = parent.assetManager.manager.get("sounds/ping.wav", Sound.class);
        boing = parent.assetManager.manager.get("sounds/boing.wav",Sound.class);

        sb = new SpriteBatch();
        // Create our new rendering system
        RenderingSystem renderingSystem = new RenderingSystem(sb);
        cam = renderingSystem.getCamera();
        sb.setProjectionMatrix(cam.combined);

        //create a pooled engine
        engine = new PooledEngine();

        // add all the relevant systems our engine should run
        engine.addSystem(new AnimationSystem());
        engine.addSystem(renderingSystem);
        engine.addSystem(new PhysicsSystem(world));
        engine.addSystem(new PhysicsDebugSystem(world, renderingSystem.getCamera()));
        engine.addSystem(new CollisionSystem());
        engine.addSystem(new PlayerControlSystem(controller));

        // create some game objects
//        createPlayer();
//        createPlatform(2,2);
//        createPlatform(2,7);
//        createPlatform(7,2);
//        createPlatform(7,7);
//
//        createFloor();

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }
}
