package model;

public class GeradorID {
    private static int currentId = 1;

    // Método para obter o próximo ID
    public static int getNextId() {
        return currentId++;
    }
}
