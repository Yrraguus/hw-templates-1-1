import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    public int age;
    public String address;
    public boolean hasAge;

    public Person(String name, String surname, int age, String address, boolean hasAge) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.hasAge = hasAge;
    }

    public boolean hasAge() {
        return this.hasAge;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        OptionalInt opInt = OptionalInt.of(age);
        return opInt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age++;
        }
    }

    @Override
    public String toString() {
        if (this.hasAge) {
            return (this.getName() + " " + this.getSurname() + ", возраст " + this.getAge().orElseThrow() + ", " + this.getAddress());
        } else {
            return (this.getName() + " " + this.getSurname() + ", " + this.getAddress());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname);
    }

    public PersonBuilder newChildBuilder() throws Exception {
        return new PersonBuilder()
                .setName(name)
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.getAddress());
    }
}
