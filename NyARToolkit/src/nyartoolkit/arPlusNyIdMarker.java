//package nyartoolkit;

import processing.core.*;
import processing.video.*;
import jp.nyatla.nyar4psg.*;

public class arPlusNyIdMarker extends PApplet {

    Capture cam;
    MultiMarker nya;
    PShape rocket;
    //PShape xbox;

    public void setup() {
        size(640, 480, P3D);
        colorMode(RGB, 100);
        println(MultiMarker.VERSION);
        cam = new Capture(this, 640, 480);
        nya = new MultiMarker(this, width, height, "camera_para.dat", NyAR4PsgConfig.CONFIG_PSG);
        nya.addARMarker("patt.hiro", 80);//id=0
        nya.addARMarker("patt.kanji", 80);//id=1
        nya.addNyIdMarker(0, 80);//id=2
        nya.addNyIdMarker(1, 80);//id=3
        rocket = loadShape("models//basketball.obj");
        //xbox = loadShape("models//cow.obj");
        rocket.scale(1);
        //xbox.scale(20);
        cam.start();
    }

    public void draw() {
        if (cam.available() != true) {
            return;
        }
        cam.read();
        nya.detect(cam);
        background(0);
        nya.drawBackground(cam);//frustum\u3092\u8003\u616e\u3057\u305f\u80cc\u666f\u63cf\u753b
        for (int i = 0; i < 4; i++) {
            if ((!nya.isExistMarker(i))) {
                continue;
            }
            
            if (nya.isExistMarker(0)) {
                nya.beginTransform(0);
                shape(rocket);
                nya.endTransform();
            }
            if (nya.isExistMarker(1)) {
                nya.beginTransform(1);
                //shape(xbox);
                nya.endTransform();
            }
            
            //System.out.println(nya.isExistMarker(1));
            
            //fill(100 * (((i + 1) / 4) % 2), 100 * (((i + 1) / 2) % 2), 100 * (((i + 1)) % 2));
            //shape(rocket);
            //translate(0, 0, 20);
            //box(40);
            
        }
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"arPlusNyIdMarker"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
