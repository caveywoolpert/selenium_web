package lifebox;

import lifebox.home.page.*;
import lifebox.welcome.page.LB331Test;
import lifebox.welcome.page.LB333Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Dmitriy.Kruchek on 26.12.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({LB2232Test.class, LB336Test.class, LB2233Test.class, CheckLeftGridPagesOpen.class, CheckUploadFunction.class, CheckCreateFolderFunction.class})
public class TestSuiteHomePage {
}
