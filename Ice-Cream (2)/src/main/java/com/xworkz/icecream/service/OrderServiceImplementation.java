package com.xworkz.icecream.service;

import com.xworkz.icecream.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private List<String> couponList;

    @Autowired
    private Map<String, Double> flavourPriceMap;

    @Autowired
    private Map<String, Double> addOnPriceMap;

    @Override
    public boolean save(OrderDTO orderDTO) {
        if (orderDTO == null) {
            System.out.println("OrderDTO is null");
            return false;
        }

        String name = orderDTO.getName();
        if (name == null || name.trim().isEmpty() || name.length() > 20) {
            System.out.println("Invalid name");
            return false;
        }

        String flavour = orderDTO.getFlavour();
        if (!flavourPriceMap.containsKey(flavour)) {
            System.out.println("Invalid flavour selected");
            return false;
        } else {
            double price = flavourPriceMap.get(flavour);
            System.out.println("Flavour: " + flavour + ", Price: ₹" + price);
        }

        Integer quantity = orderDTO.getQuantity();
        if (quantity == null || quantity <= 0 || quantity > 10) {
            System.out.println("Invalid quantity");
            return false;
        }

        Boolean takeaway = orderDTO.getTakeAway();
        if (takeaway == null) {
            System.out.println("TakeAway must be selected");
            return false;
        }

        String coupon = orderDTO.getCoupon();
        if (coupon != null && !coupon.trim().isEmpty() && !couponList.contains(coupon)) {
            System.out.println("Invalid coupon: " + coupon);
            return false;
        }

        String addOns = orderDTO.getAddOns();
        if (addOns == null || addOns.trim().isEmpty()) {
            System.out.println("Add-ons are missing");
            return false;
        } else {
            System.out.println("Add-ons: " + addOns);
        }

        double total = calculateTotal(orderDTO);
        System.out.println("Total Price: ₹" + total);
        return true;
    }

    @Override
    public double calculateTotal(OrderDTO dto) {
        double basePrice = flavourPriceMap.getOrDefault(dto.getFlavour(), 0.0);
        double total = basePrice * dto.getQuantity();

        // Add-on price (if multiple add-ons are comma-separated)
        if (dto.getAddOns() != null && !dto.getAddOns().trim().isEmpty()) {
            String[] addOnItems = dto.getAddOns().split(",");
            for (String addOn : addOnItems) {
                total += addOnPriceMap.getOrDefault(addOn.trim(), 0.0);
            }
        }

        if (Boolean.TRUE.equals(dto.getTakeAway())) {
            total += 30.0;
        }

        String coupon = dto.getCoupon();
        if (coupon != null && couponList.contains(coupon)) {
            total -= 20.0;
        }

        return Math.max(total, 0); // Avoid negative totals
    }
}
