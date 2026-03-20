package resg.ert;

import static resg.ert.Main.SCR_HEIGHT;
import static resg.ert.Main.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Tube {

    Texture textureUpperTube;
    Texture textureDownTube;
    Random random = new Random();
    int width = 200;
    int height = 700;
    int x;
    int gapHeight = 400;
    int gapY;
    int padding = 20;
    int distanceBetweenTubes;
    Bird bird;

    public Tube(int tubeCount , int tubeInx){
        textureUpperTube = new Texture("tubes/tube_flipped.png");
        textureDownTube = new Texture("tubes/tube.png");
        gapY  = gapHeight / 2 + random.nextInt(SCR_HEIGHT - 2*(padding + gapHeight/2));
        distanceBetweenTubes = (SCR_WIDTH + width)/(tubeCount - 1);

        x = distanceBetweenTubes * tubeInx + SCR_WIDTH;

    }
    int speed = 10;
    public void move(){
        x -= speed;
        if (x <= - height){
            x =  SCR_WIDTH;
            gapY = gapHeight / 2 + random.nextInt(SCR_HEIGHT - 2*(padding + gapHeight/2));
        }

    }

    public void drow(Batch batch ){
        batch.draw(textureUpperTube , x , gapY + (gapHeight/2) , width , height );
        batch.draw(textureDownTube , x , gapY - (gapHeight / 2) - height, width , height);
    }
    public void dispose(){
        textureUpperTube.dispose();
        textureDownTube.dispose();
    }
    public boolean IsHit (Bird bird) {
        if (bird.x + bird.width >= x && bird.x <= x + width / 2 && bird.y <= gapY - gapHeight / 2) {
            return true;
        } else if (bird.y + bird.height >= gapY + gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x + width / 2 ){
            return true;
        }else {
            return false;
        }
    }





}
