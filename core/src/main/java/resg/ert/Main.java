package resg.ert;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public SpriteBatch batch;
    public OrthographicCamera camera;

    public static final int SCR_WIDTH = 1280;
    public static final int SCR_HEIGHT = 720;

    ScreenGame screenGame;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

        screenGame = new ScreenGame(this);
        setScreen(screenGame);
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
