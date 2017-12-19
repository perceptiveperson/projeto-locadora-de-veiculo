package validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CaracterMaximo implements ConstraintValidator<CaracterMax, String> {

	private String value;

	@Override
	public void initialize(CaracterMax constraintAnnotation) {
		this.value = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {		
		
		if ( !(value == null || value.equals("")) ) {
		for (int i = 0; i < value.length(); i++)
			if ( !Character.isJavaLetter(value.charAt(i)) )
				return false;

		if (value.length() > Integer.parseInt(this.value))
			return false;
		}

		return true;
	}

}
