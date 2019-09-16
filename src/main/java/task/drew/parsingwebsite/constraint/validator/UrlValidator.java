package task.drew.parsingwebsite.constraint.validator;

import lombok.extern.slf4j.Slf4j;
import task.drew.parsingwebsite.constraint.anotation.ValidUrl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class UrlValidator implements ConstraintValidator<ValidUrl, String> {

    private static final String URL_PATTERN = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|,!:.;]*[-a-zA-Z0-9+@#/%=&_|]";

    @Override
    public void initialize(ValidUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        return urlValid(url);
    }

    private boolean urlValid(String url){
        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(url);

        return matcher.matches();
    }
}
