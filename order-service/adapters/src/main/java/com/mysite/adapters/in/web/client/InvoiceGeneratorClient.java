package com.mysite.adapters.in.web.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "invoiceGeneratorClient",
        url = "https://invoice-generator.com"
)
public interface InvoiceGeneratorClient {

    @PostMapping(
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    @Headers("Authorization: Bearer {apiKey}")
    byte[] generateInvoice(
            @RequestHeader("Authorization") String authorization,
            @RequestBody MultiValueMap<String, String> formData
    );
}
