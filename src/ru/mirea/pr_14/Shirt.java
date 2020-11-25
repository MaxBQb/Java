package ru.mirea.pr_14;

public class Shirt {
    String id;
    String name;
    String color;
    String size;

    Shirt(String id, String name, String color, String size) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String toString() {
        return String.format(
                "Shirt(\n\t'id': '%s'," +
                      "\n\t'type': '%s'," +
                      "\n\t'color': '%s'," +
                      "\n\t'size': '%s'\n)",
                id, name, color, size);
    }
}

