package resg.ert;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    Main main;

    Bird bird;
    Tube tube;
    int tubeCount = 4;
    Tube[] tubes;
    private void initTubes(){
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount , i);
        }
    }

    ScreenGame(Main main) {
        this.main = main;
        bird = new Bird(300, 500 , 15 , 250 , 200 );

        initTubes();

    }


    boolean isGameOver;

    @Override
    public void show() {
        boolean isGameOver = false;

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()){
            bird.OnClick();

        }
        bird.fly();
        for (Tube tube : tubes) {
            tube.move();
            if (tube.IsHit(bird)){
                isGameOver = true;
                System.out.println("hit");
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);
        main.batch.begin();

        bird.draw(main.batch);

        for (Tube tube : tubes) tube.drow(main.batch);
        main.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bird.dispose();
        tube.dispose();

    }
}
