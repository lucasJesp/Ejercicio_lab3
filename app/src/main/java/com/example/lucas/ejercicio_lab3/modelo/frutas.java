package com.example.lucas.ejercicio_lab3.modelo;

/**
 * Created by Lucas on 19-feb-19.
 */

public class Frutas {


    private String name;
    private String description;
    private int imgBackground;
    private int imgIcon;
    private int quantity;

    // Valores accesibles estáticamente
    public static final int LIMIT_QUANTITY = 10;
    public static final int RESET_VALUE_QUANTITY = 0;

    public Frutas(String name, String description, int imgBackground, int imgIcon, int quantity) {
        this.name = name;
        this.description = description;
        this.imgBackground = imgBackground;
        this.imgIcon = imgIcon;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgBackground() {
        return imgBackground;
    }

    public void setImgBackground(int imgBackground) {
        this.imgBackground = imgBackground;
    }

    public int getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static int getLimitQuantity() {
        return LIMIT_QUANTITY;
    }

    public static int getResetValueQuantity() {
        return RESET_VALUE_QUANTITY;
    }
}
