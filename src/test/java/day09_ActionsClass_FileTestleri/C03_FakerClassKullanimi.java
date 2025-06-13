package day09_ActionsClass_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C03_FakerClassKullanimi {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.name().firstName()); //Shanell
        System.out.println(faker.name().nameWithMiddle());//Kenya Kuhic Olson
        System.out.println(faker.name().username()); //jules.okon

        System.out.println(faker.address().zipCode()); //60664-1119
        System.out.println(faker.address().fullAddress()); //Suite 954 10445 Wiegand Tunnel, McKenziefurt, CO 91623
        System.out.println(faker.address().cityName()); //McLaughlinchester

        System.out.println(faker.internet().emailAddress()); //charita.davis@hotmail.com
        System.out.println(faker.internet().password()); //2blstm6be02mny8
        System.out.println(faker.internet().url()); //www.teena-cronin.name

        System.out.println(faker.harryPotter().character()); //Justin Finch-Fletchley
        System.out.println(faker.harryPotter().house()); //Pukwudgie
    }
}
