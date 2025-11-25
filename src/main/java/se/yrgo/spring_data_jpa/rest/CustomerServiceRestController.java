package se.yrgo.spring_data_jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.spring_data_jpa.domain.Customer;
import se.yrgo.spring_data_jpa.domain.Vehicle;
import se.yrgo.spring_data_jpa.dto.CustomerDTO;
import se.yrgo.spring_data_jpa.dto.VehicleDTO;
import se.yrgo.spring_data_jpa.repository.CustomerRepository;
import se.yrgo.spring_data_jpa.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerServiceRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/customers")
    public List<CustomerDTO> allCustomersWithVehicles() {
        List<Object[]> rows = customerRepository.findAllCustomerWithVehicles();
        Map<Long, CustomerDTO> customerMap = new HashMap<>();

        for (Object[] row : rows) {
            Customer customer = (Customer) row[0];
            Vehicle vehicle = (Vehicle) row[1];

            CustomerDTO customerDTO = customerMap.get(customer.getId());
            if (customerDTO == null) {
                customerDTO = new CustomerDTO();
                customerDTO.setId(customer.getId());
                customerDTO.setName(customer.getName());
                customerDTO.setPhoneNumber( customer.getPhoneNumber());
                customerMap.put(customer.getId(), customerDTO);
            }

            if(vehicle != null) {
                VehicleDTO vehicleDTO = new VehicleDTO();
                vehicleDTO.setId(vehicle.getId());
                vehicleDTO.setRegistrationNumber(vehicle.getRegistrationNumber());
                vehicleDTO.setBrand(vehicle.getBrand());
                vehicleDTO.setModel(vehicle.getModel());
                vehicleDTO.setProductionYear(vehicle.getProductionYear());
                customerDTO.getVehicles().add(vehicleDTO);
            }
        }
        return new ArrayList<>(customerMap.values());
    }

    @PostMapping("/customers")
    public ResponseEntity<String> addCustomer(@RequestParam String name, @RequestParam String phone) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhoneNumber(phone);
        customerRepository.save(customer);
        return ResponseEntity.ok().body("Customer added successfully!");
    }

    @PostMapping("/vehicles")
    public ResponseEntity<String> addVehicle(@RequestParam String registrationNumber) {
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicleRepository.save(vehicle);
        return ResponseEntity.ok().body("Vehicle added successfully!");
    }

    @PostMapping("/assign-vehicle")
    public ResponseEntity<String> assignVehicleToCustomer(@RequestParam Long id, @RequestParam Long vehicleId) {
        Customer customer = customerRepository.findById(id).orElse(null);
        Vehicle vehicle= vehicleRepository.findById(vehicleId).orElse(null);

        if (customer != null && vehicle != null) {
            customer.getVehicles().add(vehicle);
            customerRepository.save(customer);
            return ResponseEntity.ok().body("Vehicle assigned successfully to the customer!");
        } else {
            return ResponseEntity.badRequest().body("Customer not found!");
        }

    }
    @RequestMapping("/vehicles")
    public List<Vehicle> allVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicles-by-brand")
    public ResponseEntity<List<Vehicle>> getVehiclesByBrand(@RequestParam String brand) {
        List<Vehicle> vehicles = vehicleRepository.findByBrand(brand);
        return ResponseEntity.ok().body(vehicles);
    }


    @GetMapping("/customer-id")
    public ResponseEntity<Long> getCustomerByName(@RequestParam String name) {
        Customer customer = customerRepository.findByName(name);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customer.getId());
    }
}
