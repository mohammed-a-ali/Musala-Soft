package utilites;

import com.github.javafaker.Faker;

public class FakingData {
    Faker faker = new Faker();

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getMobileNumber() {
        return faker.numerify("+3892#######");
    }

    public String getBigText() {
        return faker.friends().quote() + "\n" + faker.gameOfThrones().quote();
    }
}
