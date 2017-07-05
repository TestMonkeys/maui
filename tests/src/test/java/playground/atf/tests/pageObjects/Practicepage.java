package playground.atf.tests.pageObjects;

import org.testmonkeys.selenium.engine.pageobjects.AbstractPage;
import org.testmonkeys.selenium.engine.pageobjects.ElementAccessor;
import org.testmonkeys.selenium.engine.pageobjects.PageAccessor;
import org.testmonkeys.selenium.engine.pageobjects.elements.Select;

/**
 * Created by cpascal on 3/31/2017.
 */
@PageAccessor(name="practicePage",url = "/Practiceform/")
public class Practicepage extends AbstractPage{

    @ElementAccessor(elementName = "select", byName = "vfb-12")
    private Select select;

    public Select getSelect(){
        return select;
    }
}
