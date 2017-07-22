package playground.atf.tests.pageObjects;

import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.Select;

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
