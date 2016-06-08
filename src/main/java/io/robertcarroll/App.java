package io.robertcarroll;

public class App {
    public void engine(){
        NumberTranslator translator = new NumberTranslator();
        String input = UserInputHandler.getNumber("Enter a number to translate:");
        System.out.println( translator.translateNumber(input) );
    }

    public static void main(String[] args) {
        App app = new App();
        app.engine();
    }
}
