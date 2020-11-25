package ru.mirea.lab_3;

public abstract class Dish {
    private boolean broken;
    protected boolean dirty;
    protected String color;

    public Dish() {
        this("Белый");
    }

    public Dish(String color) {
        broken = false;
        dirty = false;
        this.color = color;
    }

    public boolean isBroken() {
        return broken;
    }

    public void Brake() {
        broken = true;
    }

    public int getShardsCount() {
        if (!broken)
            return 0;
        return (int)(3.125*getSurfaceArea());
    }

    public boolean isDirty() {
        return dirty;
    }

    public void clear() {
        if (!broken)
            dirty = false;
    }

    public int getFaryAmount() {
        if (broken || !dirty)
            return 0;
        return 1+(int)(getSurfaceArea()*0.32);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected static String getSuffix(int x, String on1, String on2, String on0) {
        x %= 100;
        if (x < 20 && x > 10)
            return on0;
        x %= 10;
        if (x == 1)
            return on1;
        if (x > 1 && x < 5)
            return on2;
        return on0;
    }

    public abstract double getSurfaceArea();

    public String toString() {
        String str = "";
        if (broken) {
            int sh_c = getShardsCount();
            str = "Разбито на "+ sh_c + " кусоч" + getSuffix(sh_c, "ек", "ка", "ков");
        } else {
            int fy_a = getFaryAmount();
            str = (dirty ? "Нужно помыть ("+fy_a+"миллилитр"+getSuffix(fy_a, "", "а", "ов")+
                    " средства)" : "Можно не мыть");
        }
        str += ", цвет: " + color;
        return str;
    }
}
