package com.example.SpringMvcTest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {

    private int id;
    private String designation;
    private float prix;
    private int quantite;

}