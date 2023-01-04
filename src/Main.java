// https://github.com/netology-code/jd-homeworks/blob/master/creational/task1/README.md

public class Main {
    public static void main(String[] args) throws Exception {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
//                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
//        System.out.println("hasAddress " + mom.hasAddress() + " hasAge " + mom.hasAge());
        System.out.println(mom);
        son.setAddress("Мельбурн");
        son.happyBirthday();
        System.out.println(son);

        try {
            new PersonBuilder()
                    .setName("Анна")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}