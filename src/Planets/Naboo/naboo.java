package Planets.Naboo;

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
    public String getLightsaberColor() {
        return lightsaberColor;
    }
    public void fanFact(){
        System.out.println("On Naboo, the Gungans and the Naboo humans have a long-standing rivalry, but they also have a history of cooperation against common threats.");
    }
}

class Gungan {
    private String name;
    private int age;
    private String occupation;
    private int midichlorianCount;
    private String lightsaberColor;

    public Gungan(String name, int age, String occupation, int midichlorianCount) {
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
        public String getLightsaberColor() {
            return lightsaberColor;
        }
        public void fanFact(){
            System.out.println("Gungans are known for their unique underwater cities and their ability to communicate with aquatic creatures.");
        }
}