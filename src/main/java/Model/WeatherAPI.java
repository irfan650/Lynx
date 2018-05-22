
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

public class WeatherAPI {

    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("list")
    private java.util.List<list> list = null;

    @JsonProperty("list")
    public java.util.List<list> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<list> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WeatherAPI{" +
                "cnt=" + cnt +
                ", list=" + list +
                '}';
    }
}
