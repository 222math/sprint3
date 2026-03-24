package resg.ert;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MovingBackground {
    Main main;
    Texture texture;
    int speed = 2;
    int x;
    MovingBackground(int backgroundIndx){
        x = main.SCR_WIDTH*backgroundIndx;
        texture = new Texture("background/game_bg.png");

    }
    public void move(){
        x -= speed;
        if (x + main.SCR_WIDTH < 0){
            x = 2*main.SCR_WIDTH  + x;
        }
    }

    public void draw(Batch batch){
        batch.draw(texture, x  , 0 , main.SCR_WIDTH , main.SCR_HEIGHT);
    }




    public void dispose(){
        texture.dispose();
    }
}
