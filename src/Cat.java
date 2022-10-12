class Cat {
    private final String name;
    private int age;

    Cat(final String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    void setAge(final int age) {
        this.age = age;
    }

    public void meow() {
        System.out.println("Meow");
    }

    private void privateMethod() {
        System.out.println("Hey, that's illegal!");
    }

    public static void publicStaticMethod(){
        System.out.println("This method is public and static.");
    }

    private static void privateStaticMethod(){
        System.out.println("This method is private and static.");
    }


}
