package io.polybius.phonevalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class MobilePhoneNumberValidator {

  public ValidationResultDto result = new ValidationResultDto();

  public ValidationResultDto validate(List<String> phoneNumbers) {
    result.setValidPhonesByCountry(new HashMap<>());
    for (int i = 0; i < phoneNumbers.size(); i++) {
    isValid(phoneNumbers.get(i));
    }
    return result;
  }

  public void isValid(String phoneNumber) {
    String country = null;
    Boolean isValid = false;
    String sanitisedPhoneNumber = phoneNumber.replaceAll("\\)", "").replaceAll("\\(", "").replaceAll("\\+", "").replaceAll("-", "");

    String countryCode = sanitisedPhoneNumber.substring(0,4);
    switch(countryCode) {
      case "3706":
        country = "LT";
        isValid = sanitisedPhoneNumber.substring(4).length() == 7;
        break;
      case "3712":
        country = "LV";
        isValid = sanitisedPhoneNumber.substring(4).length() == 7;
        break;
      case "3725":
        country = "EE";
        isValid = (sanitisedPhoneNumber.substring(3).length() == 6
                || sanitisedPhoneNumber.substring(3).length() == 7);
        break;
    }

      if (countryCode.startsWith("324")) {
        country = "BE";
        isValid = (sanitisedPhoneNumber.charAt(4) == 7 || sanitisedPhoneNumber.charAt(4) == 8
                || sanitisedPhoneNumber.charAt(4) == 9 || (sanitisedPhoneNumber.charAt(4) == 5 && sanitisedPhoneNumber.charAt(5) == 6))
                && sanitisedPhoneNumber.length() == 9;
      }
        if (isValid) {
          if (!result.getValidPhonesByCountry().containsKey(country)) {
            result.getValidPhonesByCountry().put(country, new ArrayList<>());
          }

          result.getValidPhonesByCountry().get(country).add(phoneNumber);
        } else {
          result.setInvalidPhones(new ArrayList<>());
          result.getInvalidPhones().add(phoneNumber);
        }

    }
  }

