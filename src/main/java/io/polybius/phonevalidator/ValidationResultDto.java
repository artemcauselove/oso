package io.polybius.phonevalidator;

import java.util.List;
import java.util.Map;

public class ValidationResultDto {
  public Map<String, List<String>> getValidPhonesByCountry() {
    return validPhonesByCountry;
  }

  public void setValidPhonesByCountry(Map<String, List<String>> validPhonesByCountry) {
    this.validPhonesByCountry = validPhonesByCountry;
  }

  public List<String> getInvalidPhones() {
    return invalidPhones;
  }

  public void setInvalidPhones(List<String> invalidPhones) {
    this.invalidPhones = invalidPhones;
  }

  private Map<String, List<String>> validPhonesByCountry;
  private List<String> invalidPhones;
}
