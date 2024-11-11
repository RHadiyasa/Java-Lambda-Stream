package com.hadiyasa.lambda_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStream {
    public static void main(String[] args) {
        /**
         * Stream
         * Fitur yang ada di Java 8 untuk memproses data dengan gaya functional programming
         * Beberapa operasi yang didukung oleh stream
         * 1. Filtering
         * 2. Mapping
         * 3. Data collecting
         *
         * Stream juga chaining method
         * Chaining method akan mengembalikan nilai dari asalnya dengan nilai yang baru
         *
         * Suatu Stream jika sudah digunakan dalam operasi terminal toList(), forEach(), collect(), reduce()
         * maka stream akan tertutup (consumed) dan tidak bisa digunakan kembali.
         *
         * */

        Stream<Integer> numbers = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        // System.out.println("Numbers: " + numbers.toList());
        // ini akan error, karena numbers cuma dapat di consume sekali dan sudah menjadi list.
        Stream<Integer> filteredNumbers = numbers.filter(number -> number > 5);
        System.out.println("Cara Stream: " + filteredNumbers.toList());

        // alternatifnya menggunakan List yang kemudian diubah menjadi stream.
        // Karena List dapat diakses berkali kali, berbeda dengan stream.
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("Number List: " + numberList);

        Stream<Integer> filteredNumberList = numberList.stream().filter(number -> number > 5);
        System.out.println("Filtered Number List: " + filteredNumberList.toList());

        System.out.println("-".repeat(40));

        // Normal
        int[] numbersNormal = new int[]{1, 2, 3, 4, 5};

        System.out.println("Numbers Normal: " + Arrays.toString(numbersNormal));

        List<Integer> numbersNormalFiltered = new ArrayList<>();
        for (int number : numbersNormal) {
            if (number > 2) {
                numbersNormalFiltered.add(number);
            }
        }

        System.out.println("Cara Normal: " + numbersNormalFiltered);

        System.out.println("-".repeat(40));
        // Coba menggunakan chaining (Java 8 ke atas)
        List<String> names = Stream.of("Rafi", "Rahma", "Rani", "Olla")
                .map(name -> name + " Hadiyasa") // memetakan atau mengubah
                .filter(name -> name.startsWith("Ra"))
                .filter(name -> name.contains("Rafi"))
                .toList();
        System.out.println(names);

        /*
        Stream<String> peoples = Stream.of("Rafi", "Rahma", "Rani", "Olla");
        System.out.println("Peoples: " + peoples.toList());

        ERROR karena peoples sudah diconsume
        Stream<String> filteredPeople = peoples.filter(name -> name.contains("Olla"));
        System.out.println("People: " + filteredPeople.toList());
        */

        // Convert List to Stream
        List<String> employees = List.of("Rafi","Rani","Rahma","Sari","Ratri","Suryo","Olla","Olive","Ilham","Iraini");
        List<String> child = employees.stream() // Ubah ke stream
                .map(name -> name + " Hadiyasa")
                .filter(name -> name.startsWith("Ra"))
                .toList() // ubah ke List
                .stream() // ubah ke Stream
                .toList(); // ubah lagi ke List

        System.out.println(child);

        System.out.println("-".repeat(40));

        // Gunakan object
        List<Product> products = List.of(
                new Product("P001","Baju",100000),
                new Product("P002","Topi",50000),
                new Product("P003","Celana",150000)
        );

        System.out.println(products);

        List<Product> filteredPrice = products.stream()
                .filter(product -> product.getPrice() > 120000)
                .toList();
        System.out.println(filteredPrice);

        // Kalkulasi semua harga
        Integer sumPrice = products.stream()
                .map(product -> product.getPrice()) // ubah product, untuk ambil pricenya aja
                .reduce(0, (prevPrice, currentPrice) -> prevPrice + currentPrice);
        System.out.println("Sum Price : " + sumPrice);

        // Bentuk lainnya
        Integer sumPrice2 = products.stream()
                .map(Product::getPrice)
                .reduce(0, Integer::sum);
        System.out.println("Sum Price 2 : " + sumPrice2);

    }
}
