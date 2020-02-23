package io.testoftiramisu.config;

enum Environment {
  DEV("dev"),
  LOCAL("local");

  private String name;

  Environment(String name) {
    this.name = name;
  }

  /** Returns {@link Environment} by it's label provided as a String. */
  public static Environment findByName(String label) {
    for (Environment environment : Environment.values()) {
      if (environment.name.equalsIgnoreCase(label)) {
        return environment;
      }
    }
    return null;
  }

  /** Returns name of Environment as a String. */
  public String getName() {
    return name;
  }
}
