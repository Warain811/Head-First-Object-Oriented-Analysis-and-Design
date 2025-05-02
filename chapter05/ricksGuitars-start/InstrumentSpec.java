import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class InstrumentSpec {

  private Map<String, String> properties;

  public InstrumentSpec(Map<String, String> properties) {
    if (properties == null) {
      this.properties = new HashMap<String, String>();
    } else {
      this.properties = new HashMap<String, String>();
    }
  }

  public String getProperty(String key) {
    return properties.get(key);
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public boolean matches(InstrumentSpec otherSpec) {
    for (Iterator<String> i = otherSpec.getProperties().keySet().iterator(); i.hasNext();) {
      String property = i.next();

      if(!(this.getProperty(property).equals(
          otherSpec.getProperty(property)))) {
        return false;
      }

    }
    return true;
  }

}