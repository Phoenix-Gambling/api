package phoenix.api.annotation;

public @interface Icon {

    int width();

    int height();

    String[] path();

    String color() default "white";

}
