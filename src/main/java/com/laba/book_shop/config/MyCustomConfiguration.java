package com.laba.book_shop;

import com.laba.book_shop.entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyCustomConfiguration implements BeanFactoryPostProcessor {
    private static final String PATH_TO_FILE = "src/main/resources/person.txt";
    private int beanCounter = 1;


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Person> personsMap = loadPersonsFromTxtFile();
        personsMap.forEach((beanId, person) -> beanFactory.registerSingleton(beanId, person));
    }

    private Map<String, Person> loadPersonsFromTxtFile() {
        Map<String, Person> personsMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    Person person = new Person();
                    person.setName(name);
                    person.setAge(age);
                    String beanId = "personBean" + beanCounter++;
                    personsMap.put(beanId, person);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return personsMap;
    }
}
