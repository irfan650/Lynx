
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
public class list {
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = null;
    @JsonProperty("dt_txt")
    private String dtTxt;

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    @JsonProperty("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public String toString() {
        return "list{" +
                ", main=" + main +
                ", weather=" + weather +
                ", dtTxt='" + dtTxt + '\'' +
                '}';
    }

}
