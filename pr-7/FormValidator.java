import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength { int value(); }

class SignupForm {
    @NotBlank
    String name;
    @NotBlank
    @MaxLength(20)
    String email;

    SignupForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class FormValidator {
    static List<String> validate(Object object) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (field.isAnnotationPresent(NotBlank.class) &&
                (value == null || value.toString().trim().isEmpty())) {
                errors.add(field.getName() + " must not be blank");
            }
            MaxLength max = field.getAnnotation(MaxLength.class);
            if (max != null && value != null && value.toString().length() > max.value()) {
                errors.add(field.getName() + " must be at most " + max.value() + " characters");
            }
        }
        return errors;
    }
    public static void main(String[] args) throws Exception {
        SignupForm form = new SignupForm("", "verylongemailaddress@example.com");
        List<String> errors = validate(form);
        System.out.println("Validation errors:");
        for (String error : errors) System.out.println("- " + error);
        System.out.println("Total errors: " + errors.size());
    }
}