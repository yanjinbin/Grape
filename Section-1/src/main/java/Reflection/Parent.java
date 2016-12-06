package Reflection;

/**
 * Created by Silver & Bullet
 * since 2016-十一月
 */
public class Parent  implements Family {
    private int parentheight;

    @Deprecated
    public int getParentheight() {
        return parentheight;
    }

    public void setParentheight(int parentheight) {
        this.parentheight = parentheight;
    }

    public int getParentage() {
        return parentage;
    }

    public void setParentage(int parentage) {
        this.parentage = parentage;
    }


    protected int parentage;

    public String parentname;

    public Parent(int parentheight, int parentage, String parentname) {
        this.parentheight = parentheight;
        this.parentage = parentage;
        this.parentname = parentname;
    }

    public Parent(int parentheight, int parentage) {
        this.parentheight = parentheight;
        this.parentage = parentage;
    }

    public Parent(String parentname) {
        this.parentname = parentname;
    }

    public Parent() {
    }

    private Integer  print(String descript){
        System.out.println("打印script字符-----"+descript);
        return  1;
    }
}
