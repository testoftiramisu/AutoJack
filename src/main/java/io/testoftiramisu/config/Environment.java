package io.testoftiramisu.config;

enum Environment {
  DEV("dev"),
  LOCAL("local");

  private String name;

  Environment(String name) {
    this.name = name;
  }

  public static Environment findByName(String label) {
    for (Environment environment : Environment.values()) {
      if (environment.name.equalsIgnoreCase(label)) {
        return environment;
      }
    }
    return null;
  }

  public String getName() {
    return name;
  }
}
