package validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroMaximo implements ConstraintValidator<NumeroMax, String> {

	private String value;

	@Override
	public void initialize(NumeroMax constraintAnnotation) {
		this.value = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {		
		
		if ( !(value == null || value.equals("")) ) {
		for (int i = 0; i < value.length(); i++)
			if ( !Character.isDigit(value.charAt(i)) )
				return false;

		if (value.length() > Integer.parseInt(this.value))
			return false;
		}		
		
		return true;
	}

}
