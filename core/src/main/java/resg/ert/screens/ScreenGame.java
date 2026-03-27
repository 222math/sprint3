package resg.ert.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import resg.ert.characters.Bird;
import resg.ert.characters.Tube;
import resg.ert.Main;
import resg.ert.components.MovingBackground;
import resg.ert.components.PointCounter;


public class ScreenGame implements Screen {

    Main main;

    Bird bird;
    Tube tube;
    MovingBackground movingBackground;
    PointCounter pointCounter;
    ScreenRestart screenRestart;
    int tubeCount = 4;
    Tube[] tubes;
    MovingBackground[] backgrounds;
    int gamePoints;
    public boolean isGameOver;
    private void initTubes(){
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount , i);
        }
    }


    public ScreenGame(Main main) {
        this.main = main;
        bird = new Bird(300, 500 , 15 , 200 , 175 );
        pointCounter = new PointCounter(25 , 100);
        movingBackground = new  MovingBackground("background/game_bg.png");
        initTubes();

    }




    @Override
    public void show() {
        boolean isGameOver = false;

        gamePoints = 0;

    }

    @Override
    public void render(float delta) {
        if (isGameOver){
            screenRestart = new ScreenRestart(this.main , gamePoints);
            main.setScreen(screenRestart);
        }
        float deltaTime = Gdx.graphics.getDeltaTime();
        if (deltaTime > 0.1){
            System.out.println(deltaTime);
        }

        if (Gdx.input.justTouched()){
            bird.OnClick();
        }
        bird.fly();
        if (!bird.inField()){
            System.out.println("not in field");
            isGameOver = true;
        }
        for (Tube tube : tubes) {
            tube.move();
            if (tube.IsHit(bird)){
                isGameOver = true;
                System.out.println("hit");
            } else if (tube.NeedAddPoint(bird)) {
                gamePoints += 1;
                System.out.println(gamePoints);
                tube.setPointReceived();
            }
        }
        movingBackground.move();



        ScreenUtils.clear(1, 0, 0, 1);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);

        main.batch.begin();

        movingBackground.draw(main.batch , movingBackground.x1);
        movingBackground.draw(main.batch , movingBackground.x2);


        bird.draw(main.batch);


        for (Tube tube : tubes) tube.drow(main.batch);

        pointCounter.draw(main.batch, gamePoints);


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
        pointCounter.dispose();
        movingBackground.dispose();
    }
}
