import beautifuldonkey.BFSDataMain;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BFSDataMainTest {

  @Mock
  private BFSDataMain bfsData;

  @Test
  public void mainTest(){
//    beautifuldonkey.BFSDataMain bfsData = new beautifuldonkey.BFSDataMain();
    bfsData = new BFSDataMain();
    bfsData.main(new String[]{});
//    assertThat(bfsData.isServerRunning(),is(true));
  }
}
