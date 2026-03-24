package resg.ert;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;


public class ScreenGame implements Screen {

    Main main;

    Bird bird;
    Tube tube;
    MovingBackground movingBackground;
    PointCounter pointCounter;
    int tubeCount = 2;
    Tube[] tubes;
    MovingBackground[] backgrounds;
    int gamePoints;
    private void initTubes(){
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount , i);
        }
    }
    private void initMovingBackground(){
        backgrounds = new MovingBackground[2];
        for (int i = 0; i < 2; i++) {
            backgrounds[i] = new MovingBackground(i);
        }
    }

    ScreenGame(Main main) {
        this.main = main;
        bird = new Bird(300, 500 , 15 , 250 , 200 );
        pointCounter = new PointCounter(25 , 100);
        initMovingBackground();
        initTubes();

    }


    boolean isGameOver;

    @Override
    public void show() {
        boolean isGameOver = false;
        gamePoints = 0;

    }

    @Override
    public void render(float delta) {

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
        for (MovingBackground movingBackground : backgrounds) {
            movingBackground.move();
        }


        ScreenUtils.clear(1, 0, 0, 1);
        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);
        main.batch.begin();

        for (MovingBackground movingBackground : backgrounds) movingBackground.draw(main.batch);

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
