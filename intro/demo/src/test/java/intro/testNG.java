package intro;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.testng.annotations.Test;

public class testNG {

  @Test //ovako pokrecem testove
  public void Demo() {
    System.out.println("hello Upoje Upojevicu");
  }

  @Test
  public void SecondTest() {
    System.out.println("drugi test");
  }
}
