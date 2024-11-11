package com.hadiyasa.lambda_stream;

import com.hadiyasa.lambda_stream.utils.Helper;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExampleLambda {
    public static void main(String[] args) {
        /**
         *
         * Lambda : Cara untuk mengekspresikan anonymous class di java menjadi lebih singkat.
         * Anonymous Class : sebuah class yang tidak memiliki nama. Jika tidak ingin melakukan implementasi
         * interface, maka bisa menggunakan anonymous class.
         *
         * */
        CustomerService customerService = new CustomerServiceImpl();
        System.out.println("Cara 1 : Implementasi Method");
        customerService.getCustomersById();

        System.out.println("Cara 2 : Menggunakan anonymous class");
        CustomerService customerService2 = new CustomerService() {
            @Override
            public void getCustomersById() {
                System.out.println("Detail Customer 2");
            }
        };
        customerService2.getCustomersById();

        /** Lambda hanya digunakan untuk interface yang memiliki 1 method abstract
         * Jika mebih dari satu, maka harus menggunakan cara 1 atau cara 2
         * Lambda hanya bisa di Java versi 8
         * Serta menambahkan anotasi @FunctionInterface (optional)
         * */
        System.out.println("Cara 3 : Menggunakan Lambda");
        CustomerService customerService3 = () -> System.out.println("Detail Customer 3");
        customerService3.getCustomersById();

        /** Interface Calculator */
        System.out.println("-".repeat(40));
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;

        int a = 10;
        int b = 5;
        System.out.println("Penjumlahan " + a + " + " + b + " = " + addition.calculate(a,b));
        System.out.println("Pengurangan " + a + " - " + b + " = " + subtraction.calculate(a,b));

        /**
         * Lambda yang disediakan oleh Java
         * 1. Function<T, R> : Lambda yang menerima 1 parameter generic dan return type generic
         *      - T : Type Parameter
         *      - R : Return Type
         * 2. Consumer<T> : Lambda yang menerima 1 parameter generic dan void
         *      - T : Type Parameter
         * 3. Predicate<T> : Lambda yang menerima 1 parameter generic dan return type boolean
         *                  (cocok untuk filtering / validasi)
         * 4. Supplier<T> : Lambda yang memiliki return type generic tanpa memiliki parameter
         *
         * */

        /** Interface Function */
        System.out.println("-".repeat(40));
        Function<String, String> helloLambda = (name) -> {
            return "Hello " + name;
        };
        // var -> Java 10 (untuk tipe data yang otomatis diidentifikasi oleh compiler)
        var rafi = helloLambda.apply("Rafi");
        System.out.println(rafi);


        // Consumer
        System.out.print("Accept Number = ");
        Consumer<Integer> printNumber = (number) -> System.out.println(number);
        printNumber.accept(10);

        // Predicate
        String username = "Rafi";
        Predicate<String> validateName = (name) -> username.equals(name);

        System.out.print("Validate Name " + username + " = ");
        System.out.println(validateName.test("Rafi"));

        System.out.print("Validate Name " + username + " = ");
        System.out.println(validateName.test("Rahma"));

        // Supplier
        Supplier<Long> lambdaSupplier = () -> 15L;
        System.out.print("Lambda Supplier = ");
        System.out.println(lambdaSupplier.get());

        System.out.println("-".repeat(40));

        Helper.inputString("Input Nama (Tidak boleh kosong/Min 6 Karakter)",
                input -> (!input.isBlank() && input.length() > 6));

        Helper.inputInteger("Input Umur (Minimal 17 Tahun)",
                input -> input >= 17);
    }
}
