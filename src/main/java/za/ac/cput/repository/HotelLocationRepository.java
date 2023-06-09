/* HotelLocationRepository.java
 Repository for Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.repository;

import za.ac.cput.domain.HotelLocation;

import java.util.HashSet;
import java.util.Set;

public class HotelLocationRepository implements IHotelLocationRepository {

    private static HotelLocationRepository repository= null;
    private Set<HotelLocation> hotelLocationDB= null;

    private HotelLocationRepository(){
        hotelLocationDB= new HashSet<HotelLocation>();
    }
    public static HotelLocationRepository getRepository(){
        if(repository==null){
            repository = new HotelLocationRepository();
        }
        return repository;
    }

    @Override
    public HotelLocation create(HotelLocation hotelLocation) {
        boolean success = hotelLocationDB.add(hotelLocation);
            if(!success)
                return null;

                return hotelLocation;
    }

    @Override
    public HotelLocation read(String ID) {
            for (HotelLocation h: hotelLocationDB){
                if(h.getID().equals(ID))
                    return h;
            }
            return null;
    }

    @Override
    public HotelLocation update(HotelLocation hotelLocation) {

        HotelLocation oldHotelLocation= read(hotelLocation.getID());
        if(oldHotelLocation != null){
            hotelLocationDB.remove(oldHotelLocation);
            hotelLocationDB.add(hotelLocation);
            return hotelLocation;
        }
            return null;
    }

    @Override
    public boolean delete(String ID) {
        HotelLocation hotelLocationToDelete = read(ID);
            if(hotelLocationToDelete== null)
                return false;
            hotelLocationDB.remove(hotelLocationToDelete);
            return true;
    }

    @Override
    public Set<HotelLocation> getAll() {
        return hotelLocationDB;
    }
}