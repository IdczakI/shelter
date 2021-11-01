package pl.idczak.shelter.dog;

public enum Breed {

    MONGREL("mongrel"),
    LABRADOR_RETRIEVER("labrador retriever"),
    GERMAN_SHEPHERD("german shepherd"),
    GOLDEN_RETRIEVER("golden retriever"),
    BEAGLE("beagle"),
    BULLDOG("bulldog"),
    YORKSHIRE_TERRIER("yorkshire terrier"),
    BOXER("boxer"),
    POODLE("poodle"),
    ROTTWEILER("rottweiler"),
    DACHSHUND("dachshund");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Breed(String name) {
        this.name = name;
    }
}
