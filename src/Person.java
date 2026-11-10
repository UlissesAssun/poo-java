public class Person {
    // Encapsulated private attributes
    private String name;
    private int age;
    private String gender;

    // Constructor
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Business method
    public void haveBirthday() {
        this.age++;
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Portuguese alias methods for full academic compatibility
    public void fazerAniver() { haveBirthday(); }
    public void fazerAniversario() { haveBirthday(); }
    public String getNome() { return getName(); }
    public void setNome(String nome) { setName(nome); }
    public int getIdade() { return getAge(); }
    public void setIdade(int idade) { setAge(idade); }
    public String getSexo() { return getGender(); }
    public void setSexo(String sexo) { setGender(sexo); }
}
