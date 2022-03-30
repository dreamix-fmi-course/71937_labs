package collections;

import collections.entity.Dog;
import java.util.Comparator;

public class AgeComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2) {
        return dog1.getAge() - dog2.getAge();
    }
}
