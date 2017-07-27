package cloud.simple.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by za-wangshenhua on 2017/7/10.
 */
@Component
@ConfigurationProperties(prefix = "bus")
public class BusModel {

    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
