import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Purpose: To call the model's close() method on window close.
 */


public class WindowCloseListener implements WindowListener {

    MovieRentalView view;
    MovieRentalModel model;

    public WindowCloseListener(MovieRentalView view, MovieRentalModel model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    public void windowClosed(WindowEvent we){
        model.close();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
