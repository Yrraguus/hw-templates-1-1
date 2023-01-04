public class PersonBuilder {
    public String name;
    public String surname;
    public int age;
    public String address;
    public boolean hasAge;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws Exception {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.hasAge = true;
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null) {
            throw new IllegalStateException("Invalid name");
        }
        if (this.surname == null) {
            throw new IllegalStateException("Invalid surname");
        }
        return new Person(this.name, this.surname, this.age, this.address, this.hasAge);
    }
}
