package com.example.SpringMvcTest.DAO;

import com.example.SpringMvcTest.models.Produit;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IProduit {
    public List<Produit> getProduits();
    public int save(Produit p);
    public void edit(Produit p);
    public int delete(int code);
    public Produit getProduitById(int code);

}
