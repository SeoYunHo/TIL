package ÀÚ¹Ù06;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface maker {
	int num();
	String name();
	String id();
	String data() default "2077-7";
}
