package com.mysite.core.service;

import com.mysite.core.port.in.OrderService;
import com.mysite.core.port.out.InvoiceGeneratorPort;
import com.mysite.core.port.out.OrderOperations;
import com.mysite.model.MyPageable;
import com.mysite.model.Order;
import com.mysite.model.PageContent;
import com.mysite.modelPublic.command.CreateOrderCommand;
import com.mysite.modelPublic.command.UpdateOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderOperations orderOperations;
    private final InvoiceGeneratorPort invoiceGeneratorPort;

    @Override
    public Order createOrder(CreateOrderCommand request) {
        return null;
    }

    @Override
    public Order updateOrder(Long id, UpdateOrderCommand request) {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        orderOperations.getOrderById(id);
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PageContent<Order> getOrdersByUserId(MyPageable myPageable, Long userId) {
        return null;
    }

    @Override
    public byte[] generateInvoice() {

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("from", "Moja Firma Sp. z o.o.");

        formData.add("to", "Jan" + " " + "Kowalski");
        formData.add("date", LocalDateTime.now().toString());

        formData.add("items[0][name]", "Zamówienie #" + "1");
        formData.add("items[0][quantity]", "1");
        formData.add("items[0][unit_cost]", "30");

        return invoiceGeneratorPort.generateInvoice(
                "Bearer sk_AFLyDfBqYTUl52HCAdsuEj1aKkJ5EsWe",
                formData
        );
    }
}

//MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
//
//// Dane firmy (sprzedawcy) - możesz mieć na sztywno albo z konfiguracji
//formData.add("from", "Moja Firma Sp. z o.o.");
//formData.add("from_street", "ul. Przykładowa 1");
//formData.add("from_city", "Warszawa");
//formData.add("from_zip", "00-001");
//formData.add("from_country", "Polska");
//
//// Dane klienta z DTO
//CustomerDTO customer = orderDTO.getCustomer();
//AddressDTO address = orderDTO.getAddress();
//
//formData.add("to", customer.getFirstName() + " " + customer.getLastName());
//        formData.add("to_email", customer.getEmail());
//        formData.add("to_phone", customer.getPhoneNumber());
//
//        formData.add("to_street", address.getStreet() + " " + address.getApartmentNumber());
//        formData.add("to_city", address.getCity());
//        formData.add("to_zip", address.getZipcode());
//        formData.add("to_country", address.getCountry());
//
//// Numer i daty faktury
//        formData.add("number", "Faktura-" + orderDTO.getId());
//        formData.add("date", orderDTO.getOrderDate().toLocalDate().toString());
//        formData.add("due_date", orderDTO.getOrderDate().plusDays(14).toLocalDate().toString());
//
//// Pozycje faktury - jeśli masz szczegóły, mapujesz je na items
//// Na potrzeby przykładu zakładam 1 pozycję: zamówienie
//        formData.add("items[0][name]", "Zamówienie #" + orderDTO.getId());
//        formData.add("items[0][quantity]", "1");
//formData.add("items[0][unit_cost]", orderDTO.getOrderPrice().toPlainString());
//
//// Opcjonalnie: podatki, notatki itp.
//        formData.add("tax", "23");  // np. 23% VAT
//formData.add("notes", "Dziękujemy za zakup!");
//formData.add("terms", "Płatność do 14 dni.");
