
package Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * @author Hafiz Irfan Ul haq
 *
 * Forcast Bean to store releent from Json to Object
 * Json to Pojo: http://www.jsonschema2pojo.org/
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Weather {
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;
    @JsonProperty("main")
    public String getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(String main) {
        this.main = main;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
