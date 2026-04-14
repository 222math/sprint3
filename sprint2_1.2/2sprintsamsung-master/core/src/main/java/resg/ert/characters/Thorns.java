package resg.ert.characters;

import static resg.ert.Main.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

import resg.ert.screens.ScreenGameNorm;

public class Thorns {
    Random r;
    int distance = 500;
    int speed = 300;
    int width = 75 , hied = 75;
    Texture texture;
    public float x;
    int thornsInx;
    public Thorns(int thornsInx){
        r = new Random();
        this.thornsInx = thornsInx;
        this.x = SCR_WIDTH + 750*thornsInx;
        texture = new Texture("thorns/red_th.png");

    }
    public void move(float delta , float x0){
        x -= speed*delta;
        if (x+width<0){
            x = x0 + distance + r.nextInt(250);

        }
    }

    public void draw(Batch batch){
        batch.draw(texture , x , 125 , width , hied);
    }
    public void dispose(){
        texture.dispose();
    }


}
