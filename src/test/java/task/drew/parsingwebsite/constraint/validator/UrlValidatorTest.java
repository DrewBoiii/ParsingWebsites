package task.drew.parsingwebsite.constraint.validator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UrlValidatorTest {

    private UrlValidator urlValidator;

    @Before
    public void init(){
        this.urlValidator = new UrlValidator();
    }

    @After
    public void destroy(){
        this.urlValidator = null;
    }

    @Test
    public void inputCorrectSavePortUrl_whenCallUrlValid_thenOk(){
        final boolean expected = true;
        final boolean actual = urlValidator.isValid("https://simbirsoft.com", null);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputCorrectUnsavedPortUrl_whenCallUrlValid_thenOk(){
        final boolean expected = true;
        final boolean actual = urlValidator.isValid("http://www.oracle.com", null);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputNoPortUrl_whenCallUrlValid_thenNotOk(){
        final boolean expected = false;
        final boolean actual = urlValidator.isValid("simbirsoft.com", null);

        Assert.assertEquals(expected, actual);
    }

    // TODO: 18.09.2019 fix failed test
    @Test
    public void inputNoTopLevelDomainUrl_whenCallUrlValid_thenNotOk(){
        final boolean expected = false;
        final boolean actual = urlValidator.isValid("https://simbirsoft", null);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputTypoPortUrl_whenCallUrlValid_thenOk(){
        final boolean expected = false;
        final boolean actual = urlValidator.isValid("https:/simbirsoft.com", null);

        Assert.assertEquals(expected, actual);
    }

}
