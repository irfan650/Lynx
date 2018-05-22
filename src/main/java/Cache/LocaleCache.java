package Cache;
import Model.Forecast;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author Hafiz Irfan ul haq
 *
 * Functionality as cache to store Forcast data locally
 */
public class LocaleCache {

    //Key=url , value=Forecast List objects
    Map<String, List<Forecast>> Local_cache = new HashMap<String, List<Forecast>>();
    public List<Forecast> getLocal_cache(String url) {
        if(isCacheHit(url))
            return Local_cache.get(url);
        return null;
    }

    public void setLocal_cache(String url, List<Forecast> forecasts) {
        Local_cache.put(url,forecasts);
    }
    //Return True if value is not null, else false
    public boolean isCacheHit(String url) {
            if(!(Local_cache.get(url)==null)){
                System.out.println( "Cache Hit!");
                return true;
        }
        return false;

    }


}
