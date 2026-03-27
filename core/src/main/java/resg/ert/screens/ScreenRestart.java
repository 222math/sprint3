package resg.ert.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Vector;

import resg.ert.Main;
import resg.ert.components.MovingBackground;
import resg.ert.components.PointCounter;
import resg.ert.components.TextButton;

public class ScreenRestart implements Screen {
    Main main;

    MovingBackground movingBackground;

    TextButton textButton;

    PointCounter pointCounter;

    ScreenGame screenGame;

    int gamePoint;

    int x , y;

    public ScreenRestart(Main main , int gamePoints){

        this.main = main;
        this.gamePoint = gamePoints;

        movingBackground = new MovingBackground("background/restart_bg.png");
        textButton = new TextButton(300 , 300 , "restart");
        screenGame = new ScreenGame(main);
        pointCounter = new PointCounter(25 , 100);



    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            Vector3 touch = main.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            x = (int) touch.x;
            y = (int) touch.y;
            if (textButton.IsHit(x, y)) {
                ScreenGame screenGame = new ScreenGame(main);
                main.setScreen(screenGame);
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);
        main.batch.begin();

        movingBackground.draw(main.batch , movingBackground.x1);
        textButton.drow(main.batch);
        pointCounter.draw(main.batch , gamePoint);

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
    textButton.dispose();

    }
}
