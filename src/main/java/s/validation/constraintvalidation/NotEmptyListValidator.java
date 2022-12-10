package s.validation.constraintvalidation;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import s.validation.NotEmptyList;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {

	@Override
	public boolean isValid(List list, ConstraintValidatorContext context) {
		return list != null && !list.isEmpty();
	}

	@Override
	public void initialize(NotEmptyList constraint) {
		constraint.message();
	}
}
