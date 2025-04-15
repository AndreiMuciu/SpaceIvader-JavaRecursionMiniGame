package Planets.Tatooine;

class Human {
    private String name;
    private int age;
    private String occupation;
    private int midichlorianCount;
    private String lightsaberColor;

    public Human(String name, int age, String occupation, int midichlorianCount) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.midichlorianCount = midichlorianCount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getMidichlorianCount() {
        return midichlorianCount;
    }
    public void canIBeAJedi() {
        if (midichlorianCount > 10000) {
            System.out.println(name + " can be a Jedi.");
        } else {
            System.out.println(name + " cannot be a Jedi.");
        }
    }
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Occupation: " + occupation + ", Midichlorian Count: " + midichlorianCount;
    }
    public void introduce() {
        System.out.println("Hello, my name is " + name + ". I am " + age + " years old and I work as a " + occupation + ".");
    }
    public void wantsToBeAJedi() {
        if(midichlorianCount > 10000) {
            System.out.println(name + " wants to be a Jedi.");
            occupation = "Jedi";
        } else {
            System.out.println(name + " does not want to be a Jedi.");
        }
    }
    public void wantsToBeSith() {
        if(midichlorianCount > 10000) {
            System.out.println(name + " wants to be a Sith.");
            occupation = "Sith";
        } else {
            System.out.println(name + " does not want to be a Sith.");
        }
    }
    public void setLightsaberColor(String color) {
        if(occupation.equals("Jedi") || occupation.equals("Sith")) {
            lightsaberColor = color;
            System.out.println(name + "'s lightsaber color is " + lightsaberColor);
        } else {
            System.out.println(name + " cannot have a lightsaber.");
        }
    }
    public void fanFact(){
        System.out.println("Did you know that Anakin Skywalker is from Tatooine? Tatooine is a desert planet in the Outer Rim Territories of the Star Wars galaxy.");
    }
}

class TuskenRaider{
    private int age;
    private String tribe;
    private String weapon;
    private int midichlorianCount;
    public TuskenRaider(int age, String tribe, String weapon, int midichlorianCount) {
        this.age = age;
        this.tribe = tribe;
        this.weapon = weapon;
        this.midichlorianCount = midichlorianCount;
    }
    public int getAge() {
        return age;
    }
    public String getTribe() {
        return tribe;
    }
    public String getWeapon() {
        return weapon;
    }
    public int getMidichlorianCount() {
        return midichlorianCount;
    }
    public void canIBeAJedi() {
        if (midichlorianCount > 10000) {
            System.out.println("Tusken Raider can be a Jedi.");
        } else {
            System.out.println("Tusken Raider cannot be a Jedi.");
        }
    }
    public String toString() {
        return "Age: " + age + ", Tribe: " + tribe + ", Weapon: " + weapon + ", Midichlorian Count: " + midichlorianCount;
    }
    public void introduce() {
        System.out.println("AGGHHH !!!");
    }
}

class Jawa {
    private int age;
    private String tribe;
    private String weapon;
    private int midichlorianCount;

    public Jawa(int age, String tribe, String weapon, int midichlorianCount) {
        this.age = age;
        this.tribe = tribe;
        this.weapon = weapon;
        this.midichlorianCount = midichlorianCount;
    }

    public int getAge() {
        return age;
    }

    public String getTribe() {
        return tribe;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getMidichlorianCount() {
        return midichlorianCount;
    }
    public void canIBeAJedi() {
        if (midichlorianCount > 10000) {
            System.out.println("Jawa can be a Jedi.");
        } else {
            System.out.println("Jawa cannot be a Jedi.");
        }
    }
    public String toString() {
        return "Age: " + age + ", Tribe: " + tribe + ", Weapon: " + weapon + ", Midichlorian Count: " + midichlorianCount;
    }
    public void introduce() {
        System.out.println("Utinni !!!");
    }
    public void fanFact(){
        System.out.println("Did you know that Jawas are known for scavenging technology and droids on Tatooine? They are often seen in large groups, traveling in sandcrawlers.");
    }
}