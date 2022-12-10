package s.validation;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import s.validation.constraintvalidation.NotEmptyListValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {

	String message() default "A lista não pode ser vazia";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
