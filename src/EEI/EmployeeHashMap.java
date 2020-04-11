package EEI;

    /*
Hash Map
    /**
 *
 * @author kevin_gomez
 */

import java.util.HashMap;
public class EmployeeHashMap
{
    private HashMap<String,Employee> map;

    public EmployeeHashMap()
    {
        map = new HashMap<String,Employee>();
    }

    //Adds Employee object to the HashMap. Pass in Employee and gets the first name and last name, concatnates the first and last name to create HashCode.
    public void addToMap(Employee e)
    {
        String key = e.getFirstName().concat(e.getLastName());
        map.put(key, e);
    }

    //Checks if key is in the HashMap
    public boolean isKey(String firstName, String lastName)
    {
        String concatnatedName = firstName.concat(lastName);
        return map.containsKey((String)concatnatedName);
    }

    //Gets Employee object given the Key, firstName and lastName is concatnated to get HashCode
    public Employee getEmployee(String firstName, String lastName)
    {
        String concatnatedName = firstName.concat(lastName);
        return map.get((String)concatnatedName);
    }

    public Employee getEmployee(Employee e)
    {
        String concatnatedName = e.getFirstName().concat(e.getLastName());
        return map.get((String)concatnatedName);
    }

    public int sizeOfHashMap()
    {
        return map.size();
    }



}

