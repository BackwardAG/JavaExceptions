package Exceptions;

public class HW {
    public static void main(String[] args) {
        Presenter<View> prog = new Presenter<View>(new Console_View());
        prog.start();
    }
}
