package resg.ert;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {
    int x = 0, y = 0;
    int speed = 0;
    boolean jump;

    int frameCounter;
    Texture [] framesArray;

    int heightOfJump;
    final int maxHeightOfJump = 100;
    float speedy;
    int t = 0;
    void OnClick(){
        t = 0;
        speedy = speed;
        jump = true;
        heightOfJump = maxHeightOfJump + y;
    }
    int width;
    int height;


    Texture texture;
    public Bird(int x, int y , int speed , int width, int height){
        this.x = x;
        this.y = y;
        this.speed = speed;
        frameCounter = 0;
        framesArray = new Texture[]{
            new Texture("birdTiles/bird0.png"),
            new Texture("birdTiles/bird1.png"),
            new Texture("birdTiles/bird2.png"),
            new Texture("birdTiles/bird1.png"),
        };
        this.height = height;
        this.width = width;
    }
    float g = 1.05F;








    public void fly(){
        if (y >= heightOfJump){
            speedy = speed;
            jump = false;
            t = 0;
        }
        if (jump){
            t += 1;
            y += speed - (t/25)*g;;
        } else {
            t += 1;
            speedy = speed;
            y -= speed/2;
        }
    }
    int periud;
    public void draw(Batch batch){


        periud += 1;
        if (frameCounter == 4){
            frameCounter = 0;
        }
        batch.draw(framesArray[frameCounter] , x , y , width , height);
        if (periud == 5) {
            frameCounter += 1;
            periud = 0;
        }
    }
    public void dispose(){
        texture.dispose();
    }





}
