
import Cache.LocaleCache;
import Model.Forecast;
import Model.WeatherAPI;
import Model.list;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hafiz Irfan ul haq
 *
 * Test client to get weather forecast
 */
public class WeatherTestClient {
    private static LocaleCache localeCache;

    /**
     * @param args command line argument
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        localeCache = new LocaleCache();
        List<Model.Forecast> forecasts = null;
        WeatherAPI weatherAPI = null;
        String city = "";
        // API key correspond to Openweather.org account
        String appid = "91279ae256fd058263e957657b1a0835";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getErrorHandler();
        System.out.print("\n\n\n ******* Enter 'exit' any time to quit ****** \n\n");
        System.out.print("\nEnter a city name to get its's temperature: ");
        city = reader.readLine();
        System.out.println("You entered : " + city + "\n");
        while (!(city.equals("exit"))) {
            UriComponents url = UriComponentsBuilder
                    .fromHttpUrl("http://api.openweathermap.org")
                    .path("/data/2.5/forecast")
                    .queryParam("q", city)
                    .queryParam("cnt", "25")
                    .queryParam("units", "metric")
                    .queryParam("appid", appid)
                    .build();

            // check if the user already requested for the same url > cache Hit
            if (localeCache.isCacheHit(url.toUriString())) {
                forecasts = localeCache.getLocal_cache(url.toUriString());
                System.out.println("\n *** Cache Hit, Fetching data from Local Cache *** \n");
            } else {
                System.out.println("\n *** Cache Miss, Fetching  data from the server *** \n");
                try {
                    weatherAPI = restTemplate.getForObject(url.toUriString(), WeatherAPI.class);
                } catch (HttpStatusCodeException e) {
                    String code = e.getResponseBodyAsString();
                    System.out.println("\n *** Error! Please provide correct city name ** \n" + code);
                    System.out.print("\n Enter a city name to get it's temperature: ");
                    city = reader.readLine();
                    System.out.println("You entered : " + city + "\n");
                    continue;
                }

                //Get a List<Forecast>: it has all relevant forecast data for future days
                forecasts = weatherAPI.getList().stream().
                        map(WeatherTestClient::getForecast)
                        .collect(Collectors.toList());
                // populate locale cache: just a mocked cache in practice use data base
                if (!forecasts.isEmpty())
                    localeCache.setLocal_cache(url.toUriString(), forecasts);

            }
            System.out.println();
            forecasts.forEach(System.out::println);
            System.out.print("\n Enter a city name to get it's temperature: ");
            city = reader.readLine();
            System.out.println("You entered : " + city + "\n");
        }
    }

    /**
     *
     * @param weatherAPI: Class contain all data extracted from long Jason to Pojo
     *                    function use Pojo Objects to get relevant data set a Forecast class
     * @return Forecast object
     */
    public static Forecast getForecast(list weatherAPI) {
        Forecast forecast = new Forecast();
        forecast.setDescription(weatherAPI.getWeather().get(0).getDescription());
        forecast.setweather(weatherAPI.getWeather().get(0).getMain());
        forecast.setTemp(weatherAPI.getMain().getTemp());
        forecast.setPressure(weatherAPI.getMain().getPressure());
        forecast.setHumidity(weatherAPI.getMain().getHumidity());
        forecast.setDate(weatherAPI.getDtTxt());
        return forecast;
    }
}

