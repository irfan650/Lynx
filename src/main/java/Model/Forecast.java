package Model;

/**
 * @author Hafiz Irfan Ul haq
 *
 * Forcast Bean to store releent data to display
 */
public class Forecast {

    private Double temp;
    private String description;
    private String weather;
    private Double pressure;
    private Integer humidity;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getweather() {
        return weather;
    }

    public void setweather(String weather) {
        this.weather = weather;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return " Weather Forecast for " +
                ", date ='" + date + '\'' +
                ", weather ='" + weather + '\'' +
                ", description='" + description + '\'' +
                " temperature =" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity
                ;
    }


}
