package dto;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class User {
    private Faker faker = new Faker();
    private List<String> languageLevels = Arrays.asList("beginner", "intermediate","advanced","native");
    private String name = faker.name().firstName();
    private String email = faker.internet().emailAddress();
    private String password = faker.internet().password();
    private LocalDate date = faker.date().birthday(16, 100).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    private int languageLevelIndex = faker.random().nextInt(languageLevels.size());

    public Faker getFaker() {
        return faker;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLanguageLevel() {
        return languageLevels.get(languageLevelIndex);
    }
}
