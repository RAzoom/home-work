package config;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
@ConfigurationProperties("test-section")
public class ConfigSection {
    private Integer test1;
    private Integer test2;
    private Integer test3;
    private List<Integer> test4;

    public ConfigSection(){}

    public ConfigSection(Integer test1, Integer test2, Integer test3, List<Integer>test4){
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.test4 = test4;
    }

    public Integer getTest1() {
        return test1;
    }

    public Integer getTest2() {
        return test2;
    }

    public Integer getTest3() {
        return test3;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

    public void setTest3(Integer test3) {
        this.test3 = test3;
    }

    public List<Integer> getTest4() {
        return test4;
    }

    public void setTest4(List<Integer> test4) {
        this.test4 = test4;
    }
}
