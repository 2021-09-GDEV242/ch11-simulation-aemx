import java.util.List;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public abstract class Animal
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    // The animal's age.
    private int age;
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
        age = 0;
    }
    
    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    abstract public void act(List<Animal> newAnimals);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }

    /**
     * @return The animal's age.
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Sets the animal's age
     * @param the animal's new age
     */
    public void setAge(int newAge)
    {
        age = newAge;
    }

    /**
     * An animal can breed if it has reached the breeding age.
     * @return true if the animal can breed
     */
    public boolean canBreed()
    {
        return age >= getBreedingAge();
    }

    /**
     * Return the breeding age of this animal.
     * @return the breeding age of this animal.
     */
    abstract protected int getBreedingAge();
}