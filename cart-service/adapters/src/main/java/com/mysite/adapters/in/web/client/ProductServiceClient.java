package com.mysite.adapters.in.web.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "app",
        url = "${spring.cloud.openfeign.client.config.postClient.url}"
//        configuration = FeignConfig.class,
//        fallbackFactory = MedicalClinicFallbackFactory.class
)
public interface ProductServiceClient {
//    @GetMapping
//    ProductDTO getProduct()
}



//public interface MedicalClinicClient {
//
//    @PatchMapping("/reservation")
//    VisitDTO reserveVisit(@RequestBody ReserveVisitCommand reserveVisitCommand);
//
//    @GetMapping("/available")
//    PageContent<VisitDTO> getAvailableVisits(
//            Pageable pageable,
//            @RequestParam(required = false) String patientEmail,
//            @RequestParam(required = false) String doctorEmail,
//            @RequestParam(required = false) String specialization,
//            @RequestParam(required = false) VisitDayCommand visitDayCommand);
//}