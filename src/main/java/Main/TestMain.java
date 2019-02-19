package Main;

import com.sun.deploy.util.ArrayUtil;
import config.ConfigSection;
import config.GroupConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        ConfigSection.class,
        GroupConfig.class
})
public class TestMain implements CommandLineRunner {

    @Autowired
    private ConfigSection myConfig;

    @Autowired
    private GroupConfig groupConfig;

    public TestMain(ConfigSection myConfig, GroupConfig groupConfig){
        this.myConfig = myConfig;
        this.groupConfig = groupConfig;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TestMain.class);
        app.run(args);
    }

    public void run(String... args) {
        System.out.println("using environment: " + myConfig.getTest1());
        System.out.println("name: " + myConfig.getTest2());
        System.out.println("servers: " + myConfig.getTest3());
        System.out.println("servers: " + myConfig.getTest4().toString());

        System.out.println("servers: " + groupConfig.toString());
    }
}