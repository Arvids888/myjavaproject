package model;

public class DataBuilder {
    private String name;
    private String surname;
    private int age;
    private String phone;

    public static class Builder {
        private DataBuilder dataBuilder;

        public Builder() {
            dataBuilder = new DataBuilder();
        }

        public Builder withName(String name) {
            dataBuilder.name = name;
            return this;
        }
        public Builder withSurName(String surname) {
            dataBuilder.surname = surname;
            return this;
        }
        public Builder withAge(int age) {
            dataBuilder.age = age;
            return this;
        }
        public Builder withPhone(String phone) {
            dataBuilder.phone = phone;
            return this;
        }

        public DataBuilder build() {
            return dataBuilder;
        }

    }

}
