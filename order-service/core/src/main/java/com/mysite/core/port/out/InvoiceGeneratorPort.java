package com.mysite.core.port.out;

import org.springframework.util.MultiValueMap;

public interface InvoiceGeneratorPort {
    byte[] generateInvoice(String authorization, MultiValueMap<String, String> formData);
}
