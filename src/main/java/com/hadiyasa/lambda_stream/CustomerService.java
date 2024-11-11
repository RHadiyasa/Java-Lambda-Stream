package com.hadiyasa.lambda_stream;

public interface CustomerService {
    void getCustomersById();
    // void getAllCustomer(); -> tidak bisa ada method tambahan, karena lambda hanya bisa digunakan untuk interface
    // dengan 1 method abstract saja.
}
