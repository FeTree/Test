package GUI;

class DriverGui{
    // main
    public static void main(String[] args) {

        // build and show app using the event-dispatching thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI2 gui = new GUI2();
            }
        });

    }
}

