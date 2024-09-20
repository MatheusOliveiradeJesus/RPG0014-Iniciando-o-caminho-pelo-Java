package model;

public class GeradorID {
    private static int currentId = 1;
    public static int getNextId() {
        return currentId++;
    }
}
