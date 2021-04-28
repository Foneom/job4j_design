package ru.job4j.chapter_002.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
      char gender = 'M';
      int age = 23;
      byte monthOfBirth = 8;
      short dayOfBirth = 4;
      long ageOfBirth = 1998;
      double height = 180.4;
      float weight = 87.4F;
      boolean ready = true;

      LOG.debug(
              "\nUser info \ngender: {} \nage: {} \nmonthOfBirth: {} \ndayOfBirth: {} \nageOfBirth: {} \nheight: {} \nweight: {} \nwork: {}",
              gender, age, monthOfBirth, dayOfBirth, ageOfBirth, height, weight, ready);
    }
}
