package bgm.hml;

import android.app.Application;
import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
 *
 */
public class HmlApplication extends Application {

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    this.objectGraph = ObjectGraph.create();
  }

  public ObjectGraph getObjectGraph() {
    return objectGraph;
  }

}
