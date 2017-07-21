package model.facade;

import model.dao.AddressDao;
import hibernate.pojos.Address;
import java.util.List;

public class AddressFacade {
    
    AddressDao cdao = null;

    public AddressFacade() {
        cdao = new AddressDao();
    }
    
    public String createAddress(Address pAs) {
        return cdao.createAddress(pAs);
    }
    
    public List<Address> readAllAddress() {
        return cdao.readAllAddress();
    }
    
    public Address readAddressById(Integer id) {
        return cdao.readAddressById(id);
    }
    
    public Address readByIdUser(Integer id) {
        return cdao.readByIdUser(id);
    }

    public String updateAddress(Address pAs) {
        return cdao.updateAddress(pAs);
    }
    
    public String deleteAddress(Integer idAddress) {
        return cdao.deleteAddress(idAddress);
    }
    
}