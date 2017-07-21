package playfootball;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

public class PlayfootballApp extends SingleFrameApplication {

    @Override protected void startup() {
        show(new PlayfootballView(this));
    }

    @Override protected void configureWindow(java.awt.Window root) {
    }

    public static PlayfootballApp getApplication() {
        return Application.getInstance(PlayfootballApp.class);
    }

    public static void main(String[] args) {
        launch(PlayfootballApp.class, args);
    }
}